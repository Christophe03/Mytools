import { Component, OnInit } from '@angular/core';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';

@Component({
  selector: 'app-mes-commandes',
  templateUrl: './mes-commandes.page.html',
  styleUrls: ['./mes-commandes.page.scss'],
})
export class MesCommandesPage implements OnInit {
  liste: any;

  loginData: any;
  constructor(private servive: ServivesAppareilsService) { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    this.list();
  }
  list(){
    this.servive.getCommandeClient(this.loginData.id).subscribe((data)=>{
      this.liste = data;
      console.log(data);
    })
  }

}
