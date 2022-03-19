import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vente',
  templateUrl: './vente.page.html',
  styleUrls: ['./vente.page.scss'],
})
export class VentePage implements OnInit {

  loginData: any;
  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
