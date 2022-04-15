import { CommandeService } from './../Service/commande.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.scss']
})
export class CommandeComponent implements OnInit {
  mode=1
  list: any;

  constructor(
    private commandeservice :CommandeService
  ) { }

  ngOnInit(): void {
  this.commandeservice.listeCommande().subscribe((data:any)=>{
      this.list = data;
      console.log("bonjour",data)
    })
  }

  test(){
    this.mode=2;
  }
  
  test1(){
    this.mode=1;
  }
  edit(){
    this.mode=3;

  }
  details(){
    this.mode=4;

  }
  deleteitem(id: any) {
    this.commandeservice.listeCommande().subscribe(res=>{
      console.log("supprimer", res);
      
    })
  }
}