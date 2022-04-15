import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { VenteService } from '../Service/vente.service';
import  Swal  from 'sweetalert2'

@Component({
  selector: 'app-vente',
  templateUrl: './vente.component.html',
  styleUrls: ['./vente.component.scss']
})
export class VenteComponent implements OnInit {
  mode=1
  list:any
  getAcce: any;
  constructor(
    private venteservice :VenteService
  ) { }

  ngOnInit(): void {
  this.venteservice.listeVente().subscribe((data:any)=>{
      this.list = data;
      console.log("bonjour",data)
    })
  }

  test(){
    this.mode=2;
  }
  
  test1(){
    window.location.reload()
    this.mode=1;
  }
 
  details(){
    this.mode=4;

  }
  deleteitem(id: any) {
    Swal.fire({
      title: 'Êtes-vous sûr?',
      text: "Vous ne pourrez pas revenir en arrière!",
      icon: 'warning',
      showCancelButton: true,
      cancelButtonText:'Annuler',
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimez-le!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.venteservice.supprimerVente(id).subscribe(res=>{
        Swal.fire(
          'Supprimer!',
          'Votre fichier a été supprimé.',
          'success'
        )
      }
    )
    window.location.reload()
  }
      
    })
  }
  saveAcc(f:NgForm){
    window.location.reload()
    console.log("hello", f.value);
    this.venteservice.ajouterVente(f.value).subscribe((data:any)=>{
      console.log("save...", data);
      
    });
    
  }
  toDetail(event:any){
    this.mode=4;
    console.log("event", event);
    this.venteservice.afficherVenteById(event).subscribe((data:any)=>{
      console.log("get vente", data);
      this.getAcce = data
      this.details
     
      
    });
  }

  fere() {
    this.venteservice.listeAtelie().subscribe((data:any)=>{
      console.log('bonjour', data)
    })
  }

  }
  
 
    
  
  
  
  
  
 
  
  

  

