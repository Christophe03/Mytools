import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { InfosPage } from '../infos/infos.page';

import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

@Component({
  selector: 'app-imprimante',
  templateUrl: './imprimante.page.html',
  styleUrls: ['./imprimante.page.scss'],
})
export class ImprimantePage implements OnInit {
  info: any;
  loginData: any;
  infos: any;
  liste: any;
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

  list() {
    this.servive.getImprimante().subscribe((data: any)=>{
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
