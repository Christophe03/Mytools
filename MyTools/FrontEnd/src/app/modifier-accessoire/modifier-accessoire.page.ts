import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-modifier-accessoire',
  templateUrl: './modifier-accessoire.page.html',
  styleUrls: ['./modifier-accessoire.page.scss'],
})
export class ModifierAccessoirePage implements OnInit {
  photo: any=[];
  constructor() { }
  view(event){
    console.log(event.target.files[0].name);
    const img = event.target.files[0];
    this.photo = img;
  }

  ngOnInit() {
  }

}
