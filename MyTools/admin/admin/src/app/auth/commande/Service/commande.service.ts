import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  supprimerAccessoire(id: any) {
    throw new Error('Method not implemented.');
  }

  url = environment.URL;

  urlImage = this.url+'/vente/photo/';

  constructor(
    private http : HttpClient
  ) { }

  //ajout commande//
  ajoutCommande(data :any,image:File){
    const formData: FormData =new FormData();
    formData.append("file",image);
    return this.http.post(this.url+'/vente/ajouter',formData);
  }
  //Liste des commandes//
  listeCommande(){
    return this.http.get(this.url+'/vente/lister');
  }
  //Lister les commandes par id//
  afficherCommandeById(id:any){
    return this.http.get(this.url+`/vente/${id}`)
  }
  //Modifier les commandes//
  modifierCommande(data:any, id:any){
    return this.http.put(this.url+'/vente/modifier'+id,data)
  }
}
