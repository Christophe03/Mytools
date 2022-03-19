import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-achats',
  templateUrl: './achats.page.html',
  styleUrls: ['./achats.page.scss'],
})
export class AchatsPage implements OnInit {

  loginData: any;
  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
