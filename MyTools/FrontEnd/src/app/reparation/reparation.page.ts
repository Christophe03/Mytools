import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-reparation',
  templateUrl: './reparation.page.html',
  styleUrls: ['./reparation.page.scss'],
})
export class ReparationPage implements OnInit {
  photo: any=[];
  reparation: NgForm;
  body: any;
  files: any;
  loginData: any;
  appareil: any;

  constructor(public service: ServivesAppareilsService, private toastController: ToastController) { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }
  view(event){
    console.log(event.target.files[0].name);
    const img = event.target.files[0];
    this.photo = img;
  }
  reparationForm(reparation: any){

    return this.service.addreparation(reparation.value, this.loginData.id).subscribe(data =>{
      console.log(data);
      this.appareil= data;
      console.log(this.appareil);
      this.service.imageReparation(this.appareil.id, this.photo).subscribe(donne =>{
        console.log(donne);
      });
      this.ajoute();
      reparation.reset();
    });
  }

  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Article Ajouter avec Success',
      color: 'success',
      duration: 3000
    });
    toast.present();
  }

}
