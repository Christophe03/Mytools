import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalController, NavParams } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

@Component({
  selector: 'app-modifer-techniciens',
  templateUrl: './modifer-techniciens.page.html',
  styleUrls: ['./modifer-techniciens.page.scss'],
})
export class ModiferTechniciensPage implements OnInit {
  password_type= 'password';
  ajout: NgForm;
  id: any;
  confirmer: any;
  loginData: any;
  info: any;
  constructor(private navigation: NavParams, private service: ServivesAppareilsService, private model: ModalController) { }

  ngOnInit() {
    this.id = this.navigation.get('info');
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    console.log(this.id);
  }
  modifier(){
    this.service.updateProfessionnel(this.loginData.id ,this.id).subscribe((data: any)=>{
      console.log(data);

    })
  }
  togglePasswordMode(){
    this.password_type = this.password_type === 'text' ? 'password' : 'text';
  }

}
