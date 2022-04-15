import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-infos',
  templateUrl: './infos.page.html',
  styleUrls: ['./infos.page.scss'],
})
export class InfosPage implements OnInit {
  loginData: any;
  info: any;

  url= 'http://localhost:8080/mytools/appareil/photo/';

  // url= 'https://mesoutiels.herokuapp.com/mytools/appareil/photo/';
  constructor(private model: ModalController) { }

  ngOnInit() {
  }
  fermer(){
    this.model.dismiss();
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
