import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.page.html',
  styleUrls: ['./tabs.page.scss'],
})
export class TabsPage implements OnInit {
  loginData: any;

  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
