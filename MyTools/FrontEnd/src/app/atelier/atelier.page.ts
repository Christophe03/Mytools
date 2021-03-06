import { Component, OnInit } from '@angular/core';
import { AlertController, ModalController } from '@ionic/angular';

import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { ModiferTechniciensPage } from '../modifer-techniciens/modifer-techniciens.page';
@Component({
  selector: 'app-atelier',
  templateUrl: './atelier.page.html',
  styleUrls: ['./atelier.page.scss'],
})
export class AtelierPage implements OnInit {
  liste: any;
  lis: any;
  info: any;
  infos: any;
  loginData: any;
  url='http://localhost:8080/mytools/atelier/photo/';
  // url='https://mesoutiels.herokuapp.com/mytools/atelier/photo/';

  constructor(private servive: ServivesAppareilsService, private model: ModalController, private alertController: AlertController ) { }

  list() {
    this.servive.getAtelier().subscribe((data: any)=>{
      this.liste = data;
      console.log(data);
    });
  }
  lister(){
    this.servive.getProfessionnel().subscribe((data: any)=>{
      this.lis = data;
      console.log(data);
    })
  }

  async modification(data: any){
    console.log(data);
    this.servive.detailAtelers(data);
    this.infos = data;
    const model = await this.model.create({
      component: ModiferTechniciensPage,
      componentProps: {info: this.infos},
      backdropDismiss: false,
      mode: 'ios',
    });
    model.present();
  }
  delete(l: any){
    console.log("mon id", l.id);

    this.presentAlertConfirm(l.id);
    this.liste();
  }
  async presentAlertConfirm(l: any) {
    console.log("id", l.id);

    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Suppression',
      message: 'Supprimer le Techniciens',
      buttons: [
        {
          text: 'Annuler',
          role: 'cancel',
          cssClass: 'secondary',
          id: 'cancel-button',
          handler: (blah) => {
            console.log('Confirm Cancel: blah');
          }
        }, {
          text: 'Okay',
          id: 'confirm-button',
          handler: () => {
            console.log('Confirm Okay',l.id);
            this.servive.deleteProfesionnel(l.id).subscribe((data)=>{
              console.log(data);
            });
            this.list();
          }
        }
      ]
    });

    await alert.present();
  }


  ngOnInit() {
    this.list();
    this.lister();
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }


}
