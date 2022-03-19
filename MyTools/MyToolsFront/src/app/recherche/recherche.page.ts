import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.page.html',
  styleUrls: ['./recherche.page.scss'],
})
export class RecherchePage implements OnInit {

  loginData: any;
  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
