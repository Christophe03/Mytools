import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mes-article',
  templateUrl: './mes-article.page.html',
  styleUrls: ['./mes-article.page.scss'],
})
export class MesArticlePage implements OnInit {

  loginData: any;
  constructor() { }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

}
