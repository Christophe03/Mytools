import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import {  NgForm, FormsModule } from '@angular/forms';


@Component({
  selector: 'app-ajout-professionnel',
  templateUrl: './ajout-professionnel.page.html',
  styleUrls: ['./ajout-professionnel.page.scss'],
})
export class AjoutProfessionnelPage implements OnInit {
  password_type= 'password';
  ajout: NgForm;
  confirmer: any;
  atelier: any;
  body: any;
  loginData: any;

  constructor(public service: ServivesAppareilsService, private toastController: ToastController) { }

  ajoutTechnicien(ajout: NgForm){
    if(ajout.valid){
      return this.service.addProfessionnel(this.loginData.id ,ajout.value).subscribe((data)=>{
        console.log(data);
        ajout.reset();
        this.ajoute();
      });
    }
    if(ajout ==null){
      this.errer();
    }
  }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }
  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Ajouter avec Success',
      color: 'primary',
      duration: 3000
    });
    toast.present();
  }
  async errer(){
    const toast = await this.toastController.create({
      message: 'Veillez renseigner tout les champs',
      color: 'danger',
      duration: 3000
    });
    toast.present();
  }
}
