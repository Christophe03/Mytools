import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';

@Component({
  selector: 'app-bienvenu',
  templateUrl: './bienvenu.page.html',
  styleUrls: ['./bienvenu.page.scss'],
})
export class BienvenuPage implements OnInit {
  loginData: any;

  constructor(public router: Router) {

  }

  ngOnInit() {
    this.loginData = JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
    if (this.loginData != null){
      this.router.navigateByUrl('/tabs');
     }else{
       this.router.navigateByUrl('login');
     }3000;
  }

}
