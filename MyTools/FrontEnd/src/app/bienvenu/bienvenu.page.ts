import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';

@Component({
  selector: 'app-bienvenu',
  templateUrl: './bienvenu.page.html',
  styleUrls: ['./bienvenu.page.scss'],
})
export class BienvenuPage implements OnInit {

  constructor(public router: Router) {
    setTimeout(()=>{
      this.router.navigateByUrl('login');
    },3000);
   }


  ngOnInit() {
  }

}
