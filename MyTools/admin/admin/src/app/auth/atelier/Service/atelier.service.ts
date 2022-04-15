import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AtelierService {
  listeAppareil() {
    throw new Error('Method not implemented.');
  }
  url = environment.URL;

  urlImage = this.url+'/atelier/photo/';
  

  constructor(private http : HttpClient) { }
  //ajout atelier//
  ajouterAtelier(data :any,){
   
    return this.http.post(this.url+'/atelier/ajouter',data);
  }
  //Liste des ateliers//
  listeAtelier(){
    return this.http.get(this.url+'/atelier/lister');
  }
  //Lister les ateliers par id//
  afficherAtelierById(id:any){
    return this.http.get(this.url+`/atelier/${id}`)
  }
  //Modifier les ateliers//
  modifierAtelier(data:any, id:any){
    return this.http.put(this.url+'/atelier/modifier/'+id, data);
  }
  // Supprimer atelier//
  supprimerAtelier(id:any){
    return this.http.put(this.url+'/atelier/supprimer/'+id, {responseType:'text'})
  }
  

  Corbeille(){
    return this.http.get(this.url+'/atelier/corbeille');
  }
}


