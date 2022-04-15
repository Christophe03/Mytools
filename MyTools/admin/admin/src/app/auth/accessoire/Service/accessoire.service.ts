
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AccessoireService {
  delete(id: string) {
    throw new Error('Method not implemented.');
  }
  url = environment.URL;

  urlImage = this.url+'/accessoire/photo/';
  

  constructor(private http : HttpClient) { }
  //ajout accessoire//
  ajouterAccessoire(data :any){
    // const formData: FormData =new FormData();
    // formData.append("file",image);
    return this.http.post(this.url+'/accessoire/ajouter',data);
  }
  //Liste des accessoire//
  ListeAccessoires(){
    return this.http.get(this.url+'/accessoire/lister');
  }
  //Lister les accessoires par id//
  afficherAccessoireById(id:any){
    return this.http.get(this.url+`/accessoire/${id}`)
  }
  //Modifier les accessoires//
  modifierAccessoire(data:any, id:any){
    return this.http.put(this.url+'/accessoire/modifier/'+id,data)
  }
  supprimerAccessoire(id:any){
    return this.http.delete(this.url+'/accessoire/supprimer/'+id, {responseType:'text'})
  }
  Corbeille(){
    return this.http.get(this.url+'/accessoire/corbeille');
  }
}


