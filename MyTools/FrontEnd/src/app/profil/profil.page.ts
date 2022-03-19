import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.page.html',
  styleUrls: ['./profil.page.scss'],
})
export class ProfilPage implements OnInit {
  loginData: any;

  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
