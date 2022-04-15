import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AppareilService {
  url = environment.URL;

  urlImage = this.url+'/appareil/photo/';
  

  constructor(private http : HttpClient) { }
  //ajout atelier//
  ajouterAppareil(data :any,){
   
    return this.http.post(this.url+'/appareil/ajouter',data);
  }
  //Liste des ateliers//
  listeAppareil(){
    return this.http.get(this.url+'/appareil/lister');
  }
  //Lister les ateliers par id//
  afficherAppareilById(id:any){
    return this.http.get(this.url+`/appareil/${id}`)
  }
  //Modifier les ateliers//
  modifierApareil(data:any, id:any){
    return this.http.put(this.url+'/appareil/modifier/'+id,data)
  }
  // Supprimer appareil//
  supprimerAppareil(id:any){
    return this.http.delete(this.url+'/appareil/supprimer/'+id, {responseType:'text'})
  }
  Corbeille(){
    return this.http.get(this.url+'/appareil/corbeille');
  }
}



