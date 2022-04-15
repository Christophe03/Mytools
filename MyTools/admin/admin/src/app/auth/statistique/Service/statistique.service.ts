import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  url = environment.URL;

  urlImage = this.url+'/statistique/photo/';

  constructor(
    private http : HttpClient
  ) { }

  //ajout statistique//
  ajouterAtelier(data :any,image:File){
    const formData: FormData =new FormData();
    formData.append("file",image);
    return this.http.post(this.url+'/statistique/ajouter',formData);
  }
  //Liste des statistiques//
  listeStatistique(){
    return this.http.get(this.url+'/statistique/lister');
  }
  //Lister les ateliers par id//
  afficherStatistiqueById(id:any){
    return this.http.get(this.url+`/statistique/${id}`)
  }
  //Modifier les ateliers//
  modifierStatistique(data:any, id:any){
    return this.http.put(this.url+'/statistique/modifier'+id,data)
  }
}
