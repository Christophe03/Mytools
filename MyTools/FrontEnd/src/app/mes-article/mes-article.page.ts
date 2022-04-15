import { Component, OnInit } from '@angular/core';
import { AnyForUntypedForms } from '@angular/forms';
import { ModalController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { Accessoire } from '../models/accessoire';
import { ModifierAccessoirePage } from '../modifier-accessoire/modifier-accessoire.page';
import { ModifierAppareilPage } from '../modifier-appareil/modifier-appareil.page';

@Component({
  selector: 'app-mes-article',
  templateUrl: './mes-article.page.html',
  styleUrls: ['./mes-article.page.scss'],
})
export class MesArticlePage implements OnInit {
  infos: any;
  loginData: any;
  liste: any;
  donner: any
  lister: any;
  articleType: any;
  url= 'http://localhost:8080/mytools/appareil/photo/';
  // url= 'https://mesoutiels.herokuapp.com/mytools/photo/';
  constructor(private servive: ServivesAppareilsService, private model: ModalController) { }

  appareil(){
      this.servive.getAppareilAtelier(this.loginData.id).subscribe((data)=>{
        this.liste = data;
        console.log(data);
      });
    }

  async modificationAppareil(data: any){
    console.log(data);
    this.servive.detailAtelers(data);
    this.infos = data;
    const model = await this.model.create({
      component: ModifierAppareilPage,
      componentProps: {info: this.infos},
      backdropDismiss: false,
      mode: 'ios',
    });
    model.present();
  }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    this.appareil();
  }


}
