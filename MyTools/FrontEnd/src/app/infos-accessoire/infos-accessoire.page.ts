import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-infos-accessoire',
  templateUrl: './infos-accessoire.page.html',
  styleUrls: ['./infos-accessoire.page.scss'],
})
export class InfosAccessoirePage implements OnInit {
  url1='http://localhost:8080/mytools/accessoire/photo/';
  loginData: any;

  constructor(private model: ModalController) { }

  ngOnInit() {
  }
  fermer(){
    this.model.dismiss();
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
