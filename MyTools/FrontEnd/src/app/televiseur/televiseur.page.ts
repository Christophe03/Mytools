import { Component, OnInit } from '@angular/core';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { ModalController } from '@ionic/angular';
import { InfosPage } from '../infos/infos.page';
import { CommandePage } from '../commande/commande.page';
@Component({
  selector: 'app-televiseur',
  templateUrl: './televiseur.page.html',
  styleUrls: ['./televiseur.page.scss'],
})
export class TeleviseurPage implements OnInit {
  info: any;
  infos: any;
  liste: any;
  loginData: any;
  // url= 'https://mesoutiels.herokuapp.com/mytools/appareil/photo/';
  url= 'http://localhost:8080/mytools/appareil/photo/';

  constructor(private servive: ServivesAppareilsService, private model: ModalController) { }

  async settings(data: any) {
    console.log(data);
     this.servive.detailAppareils(data);
    this.infos = data;
    const modal = await this.model.create({
      component: InfosPage,
      componentProps: {info: this.infos},
      cssClass: 'setting-modal',
      backdropDismiss: false,
      mode: 'ios',
    });

    modal.present();
  }

  async commande(data: any) {
    console.log(data);
     this.servive.detailAppareils(data);
    this.infos = data;
    const modal = await this.model.create({
      component: CommandePage,
      componentProps: {info: this.infos},
      cssClass: 'setting-modal',
      backdropDismiss: false,
      mode: 'ios',
    });

    modal.present();
  }


  list() {
    this.servive.getTeleviseur().subscribe((data: any)=>{
      this.liste = data;
      console.log(data);
    });
  }

  ngOnInit() {
    this.list();
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
