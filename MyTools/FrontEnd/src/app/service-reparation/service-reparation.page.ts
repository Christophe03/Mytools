import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-reparation',
  templateUrl: './service-reparation.page.html',
  styleUrls: ['./service-reparation.page.scss'],
})
export class ServiceReparationPage implements OnInit {
  loginData: any;

  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
