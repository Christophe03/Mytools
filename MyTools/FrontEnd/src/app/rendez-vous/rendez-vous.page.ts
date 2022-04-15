import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalController, NavParams, ToastController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { RendezVous } from '../models/rendezVous';
import { Reparation } from '../models/reparation';
@Component({
  selector: 'app-rendez-vous',
  templateUrl: './rendez-vous.page.html',
  styleUrls: ['./rendez-vous.page.scss'],
})
export class RendezVousPage implements OnInit {
  ajoutCommande: any;
  loginData: any;
  user: any;
  id: any;
  services: any;
  reparation = new Reparation
  rendezVous = new RendezVous();
  constructor(private navigation: NavParams,private toastController: ToastController, private service: ServivesAppareilsService, private model: ModalController) { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    this.id = this.navigation.get('info');
  }
  fermer(){
    this.model.dismiss();
  }

  donner(form: NgForm) {
    if (form.valid){
      console.log(this.rendezVous);
      this.rendezVous.dateSaisi = form.value['dateSaisi'];
      this.rendezVous.dateRendu = form.value['dateRendu'];
      this.rendezVous.montant = form.value['montant'];
      this.rendezVous.heureSaisi = form.value['heureSaisi'];
      this.rendezVous.heureRendu = form.value['heureRendu'];
      this.rendezVous.services = this.id;


      this.service.addRendezVous(this.rendezVous, this.loginData.id).subscribe((data: any)=>{
        console.log(data);
        console.log(this.rendezVous.services);


      })

    }this.ajoute();
    form.reset();

  }
  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Date du rendez-vous envoyer avec Success',
      color: 'primary',
      duration: 3000
    });
    toast.present();
  }
  async refuse(){
    const toastes = await this.toastController.create({
      message: 'Erreur veuillez renseigner toutes les information',
      color: 'danger',
      duration: 3000
    });
    toastes.present();
  }

}
