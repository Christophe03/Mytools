import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalController, NavParams, ToastController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { Commande } from '../models/commande';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.page.html',
  styleUrls: ['./commande.page.scss'],
})
export class CommandePage implements OnInit {
  user: any;
  id: any;
  produits: any;
  commande= new Commande();
  ajoutCommande: any;
  loginData: any;
  info: any;

  constructor(private navigation: NavParams,private toastController: ToastController, private service: ServivesAppareilsService, private model: ModalController) { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    this.id = this.navigation.get('info');
  }
  fermer(){
    this.model.dismiss();
  }
  passer(form: NgForm){
    if(form.valid){
      this.commande.appareils = this.id;
      this.commande.client = this.loginData;
      this.commande.quantite = form.value['quantite'];
      this.commande.montant = this.id.prix * form.value['quantite'];
      this.service.addCommande(this.commande).subscribe((data: any)=>{
        console.log(data);
      })
    }this.ajoute();
      form.reset();
  }

  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Commande Valider',
      color: 'primary',
      duration: 3000
    });
    toast.present();
  }
}
