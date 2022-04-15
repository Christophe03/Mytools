import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

import { RendezVousPage } from '../rendez-vous/rendez-vous.page';

@Component({
  selector: 'app-service-reparation',
  templateUrl: './service-reparation.page.html',
  styleUrls: ['./service-reparation.page.scss'],
})
export class ServiceReparationPage implements OnInit {
  loginData: any;
  info: any;
  infos: any;
  notification: any;
  // url= 'https://mesoutiels.herokuapp.com/mytools/photo/';
  url= 'http://localhost:8080/mytools/services/photo/';

  constructor(private servive: ServivesAppareilsService, private model: ModalController) { }

  async settings(data: any) {
    console.log(data);
     this.servive.detailService(data);
    this.infos = data;
    const modal = await this.model.create({
      component: RendezVousPage,
      componentProps: {info: this.infos},
      cssClass: 'setting-modal',
      backdropDismiss: false,
      mode: 'ios',
    });

    modal.present();
  }

  notif(){
    this.servive.getService().subscribe((data: any)=>{
      this.notification = data;
      console.log(data);
    })
  }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    this.notif();
  }

}
