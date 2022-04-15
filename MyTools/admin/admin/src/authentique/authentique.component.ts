import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-authentique',
  templateUrl: './authentique.component.html',
  styleUrls: ['./authentique.component.scss']
})
export class AuthentiqueComponent implements OnInit {
  title = 'myApp';
  flag:boolean = true;
   
  constructor() { }

  ngOnInit(): void {
  }



  apply(value:string){
    this.flag = value == "login"?true : false;
  }


}
