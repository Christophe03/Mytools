import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalController, NavParams, ToastController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { Professionnel } from '../models/professionnel';

@Component({
  selector: 'app-modifer-techniciens',
  templateUrl: './modifer-techniciens.page.html',
  styleUrls: ['./modifer-techniciens.page.scss'],
})
export class ModiferTechniciensPage implements OnInit {
  password_type= 'password';
  ajout: NgForm;
  id: any;
  professionnel= new Professionnel();
  confirmer: any;
  loginData: any;
  info: any;
  constructor(private navigation: NavParams,private router: Router, private service: ServivesAppareilsService, private toast: ToastController) { }

  ngOnInit() {
    this.id = this.navigation.get('info');
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    console.log(this.id);
  }
  modifier(form: NgForm){
    if(form.valid){
      this.professionnel.atelier = this.loginData;
    this.professionnel.nom = form.value['nom'];
    this.professionnel.prenom = form.value['prenom'];
    this.professionnel.contact = form.value['ncontact'];
    this.professionnel.email = form.value['email'];
    this.professionnel.domaineActivite = form.value['domaineActivite'];
    this.professionnel.password = form.value['password'];
    this.professionnel.adresse = form.value['adresse'];
    this.professionnel.genre = form.value['genre'];
    this.service.updateProfessionnel(this.id.id, this.professionnel).subscribe((data: any)=>{
      console.log(data);

    })
    this.ajoute();
    }else{
      this.refuse();
    }
  }
  togglePasswordMode(){
    this.password_type = this.password_type === 'text' ? 'password' : 'text';
  }
  async ajoute(){
    const toast = await this.toast.create({
      message: 'Utilisateur Modifier avec success',
      color: 'success',
      duration: 3000
    });
    toast.present();
  }
  async refuse(){
    const toastes = await this.toast.create({
      message: 'Veuillez renseigner toutes les champs.',
      color: 'danger',
      duration: 3000
    });
    toastes.present();
  }

}
