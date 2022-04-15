import { CorbeilleService } from './corbeille.service';
import { AtelierService } from './../atelier/Service/atelier.service';
import { Component, OnInit,  } from '@angular/core';


@Component({
  selector: 'app-corbeille',
  templateUrl: './corbeille.component.html',
  styleUrls: ['./corbeille.component.scss']
})
export class CorbeilleComponent implements OnInit {

  list:any
  constructor( private atelierservice : AtelierService, private corbeilleService : CorbeilleService
   
  ) { }

  ngOnInit(): void {
  this.liste();
  }

  liste(){
    this.atelierservice.listeAtelier().subscribe((data:any)=>{
      this.list = data;
      console.log("bonjour",data)
    })
  }

  restore(id:any){
    this.corbeilleService.restoreAtelier(id, {responseType:'text'}).subscribe(data=>{
      this.liste();

    });
  }
  restores(id:any){
    this.corbeilleService.restoreAccessoire(id, {responseType:'text'}).subscribe(data=>{
      this.liste();

    });
  }
  restor(id:any){
    this.corbeilleService.restoreAppareil(id, {responseType:'text'}).subscribe(data=>{
      this.liste();

    });
  
 
}
}

