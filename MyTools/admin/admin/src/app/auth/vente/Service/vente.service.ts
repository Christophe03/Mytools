import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VenteService {

  url = environment.URL;
  listeAtelier: any;

  

  constructor(
    private http : HttpClient
  ) { }

  //ajout vente//
  ajouterVente(data:any){
  return this.http.post(this.url+'/vente/ajouter',data);
  }
  //Liste des ventes//
  listeVente(){
    return this.http.get(this.url+'/vente/lister');
  }
  //Lister les ventes par id//
  afficherVenteById(id:any){
    return this.http.get(this.url+`/vente/${id}`)
  }
  
  //Modifier les ventes//
  modifier(data:any, id:any){
    console.log("id : ", id, "data : ", data);
    data.solution = {
      id: 1
    }
    return this.http.put(this.url+'/vente/modifier/'+id,data)
  }
   // Supprimer vente//
   supprimerVente(id:any){
    return this.http.delete(this.url+'/vente/supprimer/'+id, {responseType:'text'})
}
listeAtelie(){
  return this.http.get(this.url+'/atelier/lister');
}
}
