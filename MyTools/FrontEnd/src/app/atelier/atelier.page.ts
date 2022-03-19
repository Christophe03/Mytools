import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

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

  constructor(private servive: ServivesAppareilsService, private model: ModalController ) { }

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


  ngOnInit() {
    this.list();
    this.lister();
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }


}
