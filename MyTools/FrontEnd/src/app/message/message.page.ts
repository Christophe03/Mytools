import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.page.html',
  styleUrls: ['./message.page.scss'],
})
export class MessagePage implements OnInit {
  loginData: any;
  info: any;
  infos: any;
  messagers: any;
  constructor(private servive: ServivesAppareilsService, private model: ModalController) { }

  message(){
    this.servive.getRendezVous().subscribe((data: any)=>{
      this.messagers = data;
      console.log(data);
    })
  }
  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    this.message();
  }

}
