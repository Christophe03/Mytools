import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { CommandeAccessoirePage } from '../commande-accessoire/commande-accessoire.page';
import { InfosAccessoirePage } from '../infos-accessoire/infos-accessoire.page';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

@Component({
  selector: 'app-accessoires',
  templateUrl: './accessoires.page.html',
  styleUrls: ['./accessoires.page.scss'],
})
export class AccessoiresPage implements OnInit {
  accessoire: any;
  information: any;
  liste: any;
  info: any;
  infos: any;
  loginData: any;
  url1='http://localhost:8080/mytools/accessoire/photo/';
  // url1='https://mesoutiels.herokuapp.com/mytools/accessoire/photo/';
  constructor(private servive: ServivesAppareilsService, private model: ModalController) { }

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

  async commande(data: any) {
    console.log(data);
     this.servive.detailAccessoires;
    this.infos = data;
    const modal = await this.model.create({
      component: CommandeAccessoirePage,
      componentProps: {info: this.infos},
      cssClass: 'setting-modal',
      backdropDismiss: false,
      mode: 'ios',
    });

    modal.present();
  }

  list() {
    this.servive.getAccessoires().subscribe((data: any)=>{
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
