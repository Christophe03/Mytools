import { Component, OnInit } from '@angular/core';

import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
@Component({
  selector: 'app-atelier',
  templateUrl: './atelier.page.html',
  styleUrls: ['./atelier.page.scss'],
})
export class AtelierPage implements OnInit {
  liste: any;
  loginData: any;
  url='http://localhost:8080/mytools/atelier/photo/';

  constructor(private servive: ServivesAppareilsService) { }

  list() {
    this.servive.getAtelier().subscribe((data: any)=>{
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
