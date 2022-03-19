import { Component, OnInit } from '@angular/core';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { ModalController } from '@ionic/angular';
import { InfosPage } from '../infos/infos.page';

@Component({
  selector: 'app-ordinateur',
  templateUrl: './ordinateur.page.html',
  styleUrls: ['./ordinateur.page.scss'],
})
export class OrdinateurPage implements OnInit {
  liste: any;
  info: any;
  infos: any;
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
    this.servive.getOrdinateur().subscribe((data: any)=>{
      this.liste = data;
      console.log(data);
    });
  }


  ngOnInit() {
    this.list();
  }

}
