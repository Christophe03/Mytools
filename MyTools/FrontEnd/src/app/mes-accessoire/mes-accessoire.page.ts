import { Component, OnInit } from '@angular/core';
import { AnyForUntypedForms } from '@angular/forms';
import { ModalController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { Accessoire } from '../models/accessoire';
import { ModifierAccessoirePage } from '../modifier-accessoire/modifier-accessoire.page';
import { ModifierAppareilPage } from '../modifier-appareil/modifier-appareil.page';

@Component({
  selector: 'app-mes-accessoire',
  templateUrl: './mes-accessoire.page.html',
  styleUrls: ['./mes-accessoire.page.scss'],
})
export class MesAccessoirePage implements OnInit {
  infos: any;
  loginData: any;
  donner: any
  lister: any;
  articleType: any;

  url= 'http://localhost:8080/mytools/accessoire/photo/';

  constructor(private servive: ServivesAppareilsService, private model: ModalController) { }

  accessoire(){
    this.servive.getAccessoireAtelier(this.loginData.id).subscribe((data)=>{
      this.lister = data;
      console.log(data);
    })
  }

  async modificationAccessoire(data: any){
    console.log(data);
    this.servive.detailAtelers(data);
    this.infos = data;
    const model = await this.model.create({
      component: ModifierAccessoirePage,
      componentProps: {info: this.infos},
      backdropDismiss: false,
      mode: 'ios',
    });
    model.present();
  }

  ngOnInit() {
      this.loginData=JSON.parse(localStorage.getItem('isLogin'));
      console.log(this.loginData);
      this.accessoire();
  }

}
