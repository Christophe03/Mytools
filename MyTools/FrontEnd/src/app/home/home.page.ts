import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { ModalController } from '@ionic/angular';
import { InfosAccessoirePage } from '../infos-accessoire/infos-accessoire.page';
import { InfosPage } from '../infos/infos.page';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  info: any;
  loginData: any;
  infos: any;
  accessoire: any;
  information: any;
  liste: any;
  liste2: any;
  messages: any;
  nbrMessage: any;
  notification: any;
  nbreNotfication:number = 0;
  image: any;
  url= 'http://localhost:8080/mytools/appareil/photo/';
  url1='http://localhost:8080/mytools/accessoire/photo/';
  // url= 'https://mesoutiels.herokuapp.com/mytools/appareil/photo/';
  // url1='https://mesoutiels.herokuapp.com/mytools/accessoire/photo/';
  constructor(private servive: ServivesAppareilsService,private router: Router, private model: ModalController) { }

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
  async infoAccessoire(data: any) {
    console.log(data);
    this.servive.detailAccessoires(data);
    this.accessoire = data;
    const modal = await this.model.create({
      component: InfosAccessoirePage,
      componentProps:{information: this.accessoire},
      cssClass: 'setting-modal',
      backdropDismiss: false,
      mode: 'ios',
    });
    modal.present();
  }

  list() {
    this.servive.getAppareil().subscribe((data: any)=>{
      this.liste = data;
      console.log(data);
    });
  }
  list2(){
    this.servive.getAccessoires().subscribe((data: any)=>{
      this.liste2 = data;
      console.log(data);
    });
  }
  notif(){
    this.servive.getMotification().subscribe((data: any)=>{
      this.notification = data;
      console.log(data);
      this.nbreNotfication = this.notification.length;
      console.log(this.nbreNotfication);
    })
  }
  message(){
    this.servive.getMessage().subscribe((data: any)=>{
      this.messages = data;
      console.log(data);
      this.nbrMessage = this.messages.length;
      console.log(this.nbrMessage);
    })
  }

  ngOnInit() {
    this.list();
    this.list2();
    this.notif();
    this.message();
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);

  }
}
