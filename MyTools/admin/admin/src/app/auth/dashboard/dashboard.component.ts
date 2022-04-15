import { VenteService } from './../vente/Service/vente.service';
import { AccessoireService } from './../accessoire/Service/accessoire.service';
import { AppareilService } from './../appareil/Service/appareil.service';
import { AtelierService } from './../atelier/Service/atelier.service';
import { Component, OnInit } from '@angular/core';
import { GoogleChartInterface, GoogleChartType } from 'ng2-google-charts';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit{
  nbreatelier : any;
  ateliernbr : any;
  nbreappareil : any;
  appareilnbr : any;
  nbraccessoire : any;
  accessoirenbr : any;
  nbrevente : any;
  ventenbre : any;

  constructor(private atelier : AtelierService, private appareil : AppareilService, private accessoire : AccessoireService,
    private vente : VenteService) { }
  
  ngOnInit(): void {
    this.listeAtelier();
    this.listeAppareil();
    this.listeVente();
    this.listeAccessoires();
    
  }
  
  //Nombre des atelier
  listeAtelier(){
    this.atelier.listeAtelier().subscribe((data:any)=>{
      this.ateliernbr = data
      // console.log(this.ateliernbr)
      this.nbreatelier = this.ateliernbr.length
    })

  };

  // Nombre des appareils

  listeAppareil(){
    this.appareil.listeAppareil().subscribe((data:any)=>{
      this.appareilnbr = data
      // console.log(this.appareilnbr)
      this.nbreappareil = this.appareilnbr.length
    })
};
// Nbre des accessoires
listeAccessoires(){
  this.accessoire.ListeAccessoires().subscribe((data:any)=>{
    this.accessoirenbr = data
    this.nbraccessoire = this.accessoirenbr.length
    
  })
};
// Nbre des ventes
listeVente(){
  this.vente.listeVente().subscribe((data:any)=>{
    this.ventenbre = data
    // console.log(this.ventenbre)
    this.nbrevente = this.ventenbre.length
  })
};
}
