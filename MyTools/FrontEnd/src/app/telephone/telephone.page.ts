import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { CommandePage } from '../commande/commande.page';
import { InfosPage } from '../infos/infos.page';

import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

@Component({
  selector: 'app-telephone',
  templateUrl: './telephone.page.html',
  styleUrls: ['./telephone.page.scss'],
})
export class TelephonePage implements OnInit {
  info: any;
  infos: any;
  loginData: any;
  liste: any;
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
    this.servive.getTelephone().subscribe((data: any)=>{
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
