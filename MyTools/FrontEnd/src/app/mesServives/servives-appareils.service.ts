import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { identity, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServivesAppareilsService {
  APAREIL = 'http://localhost:8080/mytools/appareil';
  ACCESSOIRES = 'http://localhost:8080/mytools/accessoire';
  ATELIER = 'http://localhost:8080/mytools/atelier';
  CLIENT = 'http://localhost:8080/mytools/client';
  PROFESSIONNEL = 'http://localhost:8080/mytools/professionnel';
  SERVICES = 'http://localhost:8080/mytools/services';
  COMMANDE = 'http://localhost:8080/mytools/commande';
  NOTIFICATION = 'http://localhost:8080/mytools/notification';
  RENVEZVOUS  = 'http://localhost:8080/mytools/rendezVous';
  MESSAGE = 'http://localhost:8080/mytools/messages';
  REPARATION = 'http://localhost:8080/mytools/reparation';

  // APAREIL = 'https://mesoutiels.herokuapp.com/mytools/appareil';
  // ACCESSOIRES = 'https://mesoutiels.herokuapp.com/mytools/accessoire';
  // ATELIER = 'https://mesoutiels.herokuapp.com/mytools/atelier';
  // CLIENT = 'https://mesoutiels.herokuapp.com/mytools/client';
  // PROFESSIONNEL = 'https://mesoutiels.herokuapp.com/mytools/professionnel';
  // SERVICES = 'https://mesoutiels.herokuapp.com/mytools/service';
  // COMMANDE = 'https://mesoutiels.herokuapp.com/mytools/commande';
  // NOTIFICATION = 'https://mesoutiels.herokuapp.com/mytools/notification';

  constructor(private http: HttpClient) {}

  //Ajouter Reparation
  public addReparation(data){
    return this.http.post(this.REPARATION+'/ajouter', data)
  }

  //Connexion client
  public loginClient(email: String,password: String){
    return this.http.get(this.CLIENT+'/connexion/'+email+"&"+password);
  }

  //Connexion atelier
  public loginAtelier(email: String,password: String){
    return this.http.get(this.ATELIER+'/connexion/'+email+"&"+password);
  }

  //Connexion professionnel
  public loginProfessionnel(email: string,password: string){
    return this.http.get(this.PROFESSIONNEL+'/connexion/'+email+"&"+password);
  }

  //Liste Professionnel
  public getProfessionnel(){
    return this.http.get(this.PROFESSIONNEL+'/lister');
  }

  //Liste des Ordinateurs
  public getOrdinateur(){
    return this.http.get(this.APAREIL+'/ListeType/ORDINATEUR');
  }

  //Liste des Téléphones
  public getTelephone(){
    return this.http.get(this.APAREIL+'/ListeType/TELEPHONE');
  }

  //Liste des Tablettes
  public getTablette(){
    return this.http.get(this.APAREIL+'/ListeType/TABLETTE');
  }
  //RENVEZVOUSListe
  public getRendezVous(){
    return this.http.get(this.RENVEZVOUS+'/lister');
  }

  //Liste des Televiseurs
  public getTeleviseur(){
    return this.http.get(this.APAREIL+'/ListeType/TELEVISEUR');
  }

  //Liste des Imprimante
  public getImprimante(){
    return this.http.get(this.APAREIL+'/ListeType/IMPRIMANTE');
  }

  //Liste Accessoires pour Ordinateur
  public getAccessoireOrdinateur(){
    return this.http.get(this.ACCESSOIRES+'AccessoireTYpe/ORDINATEUR');
  }

  //Liste Accessoire pour Telephones
  public getAccessoireTelephone(){
    return this.http.get(this.ACCESSOIRES+'AccessoireTYpe/TELEPHONE');
  }

  //Liste Accessoire pour Tablette
  public getAccessoireTablette(){
    return this.http.get(this.ACCESSOIRES+'AccessoireTYpe/TABLETTE');
  }

  //Liste Accessoire pour Televiseur
  public getAccessoireTeleviseur(){
    return this.http.get(this.ACCESSOIRES+'AccessoireTYpe/TELEVISEUR');
  }
  //Lister des Demandes de Reparation
  public getService(){
    return this.http.get(this.SERVICES+'/lister');
  }

  //Liste Accessoire pour Imprimante
  public getAccessoireImprimante(){
    return this.http.get(this.ACCESSOIRES+'/AccessoireTYpe/IMPRIMANTE');
  }
  //Liste Appareil Atelier
  public getAppareilAtelier(id: any){
    return this.http.get(this.APAREIL+'/AppareilAtelier/'+id);
  }
  public getAccessoireAtelier(id: any){
    return this.http.get(this.ACCESSOIRES+'/AccessoireAtelier/'+id);
  }
  public  getCommandeClient(id: any){
    return this.http.get(this.COMMANDE+'/commandeClient/'+id);
  }

  //Commande Ajout
  public addCommande(data){
    return this.http.post(this.COMMANDE+'/ajouter', data);
  }

  //Lister Commande
  public getCommande(){
    return this.http.get(this.COMMANDE+'/lister');
  }
  //Commande par Id
  public getCommandeId(id: any){
    return this.http.get(this.COMMANDE+'/'+id);
  }

  //Demande de réparation
  public addreparation(data, id: any){
    return this.http.post(this.SERVICES+'/ajouter/'+id, data);
  }

  //RENVEZVOUS
  public addRendezVous(data, id: any){
    return this.http.post(this.RENVEZVOUS+'/ajouter/'+id, data, {responseType: 'text'});
  }
  //MessagesService
  public getMessage(){
    return this.http.get(this.MESSAGE+'/liste')
  }

  //Icon notification
  public getMotification(){
    return this.http.get(this.NOTIFICATION+'/liste')
  }


  //Image de la demande de réparation
  public imageReparation(id: number, photo: File): Observable<any>{
    const reparation: FormData = new FormData();
    reparation.append('file', photo);
    return this.http.put(this.SERVICES+'/Ajoutphoto/'+id, reparation);
  }

  //lister les Appareils
    public getAppareil(){
      return this.http.get(this.APAREIL+'/lister');
    }

  //lister les Accessoires
    public getAccessoires(){
      return this.http.get(this.ACCESSOIRES+'/lister');
    }

  //lister les Atelier
    public getAtelier(){
      return this.http.get(this.ATELIER+'/lister');
    }

  //ajouter un Client
    public addClient(data){
      return this.http.post(this.CLIENT+'/ajouter', data, {responseType: 'text'});
    }

  //ajouter un Proffessionnel
    public addProfessionnel(id: any, data){
      return this.http.post(this.PROFESSIONNEL+'/ajouter/'+id, data, {responseType: 'text'});
    }

  //ajouter un Atelier
    public addAtelier(data){
      return this.http.post(this.ATELIER+'/ajouter', data);
    }

  //ajouter Images Atelier
    public imageAtelier(id: any, photo: File): Observable<any>{
      const atelier: FormData = new FormData();
      atelier.append('file', photo);
      return this.http.put(this.ATELIER+'/Ajoutphoto/'+id, atelier);
    }

  //ajouter Appareil
    public addAppareil(data: any, profil: string, id: any){
      return this.http.post(this.APAREIL+'/ajoute/'+profil+'/'+id, data);
    }

  //ajouter images Appareil
    public addImages(id: any, photo: File): Observable<any>{
      const article: FormData = new FormData();
      article.append('file', photo);
      return this.http.put(this.APAREIL+'/Ajoutphoto/'+id, article);
    }

  //ajouter Accessoires
    public addAccessoire(data: any, profil: string, id: any){
      return this.http.post(this.ACCESSOIRES+'/ajouter/'+profil+'/'+id, data);
    }

  //ajouter images Accessoires
    public imageAccessoire(id: any, photo: File): Observable<any>{
      const accessoire: FormData = new FormData();
      accessoire.append('file', photo);
      return this.http.put(this.ACCESSOIRES+'/Ajoutphoto/'+id, accessoire);
    }

    //Modifier Appareil
    public updateAppareil(id: number ,data){
      return this.http.put(this.APAREIL+'/modifier/'+id, data);
    }

    //Modifier Accessoire
    public updateAccessoire(id: any, data){
      return this.http.put(this.ACCESSOIRES+'/modifier/'+id, data);
    }

    //Modifer Professionnel
    public updateProfessionnel(id: any, data){
      return this.http.put(this.PROFESSIONNEL+'/modifier/'+id, data, {responseType: 'text'});
    }

    //Afficher les Appareils par id (info appareil)
    public detailAppareils(id: any){
      return this.http.get(this.APAREIL+'/'+id);
    }

    //Afficher les Accessoires par id (info accessoire)
    public detailAccessoires(id: any){
      return this.http.get(this.ACCESSOIRES+'/'+id);
    }

    //Afficher les Atelier par id (info Atelier)
    public detailAtelers(id: any){
      return this.http.get(this.ATELIER+'/'+id);
    }

    //Afficher les  service par id (info Service)
    public detailService(id: any){
      return this.http.get(this.SERVICES+'/'+id);
    }
    //Supprimer Professionnel
    public deleteProfesionnel(id: any){
      return this.http.delete(this.PROFESSIONNEL+'/supprimer/'+id, {responseType: 'text'});
    }
    //Supprimer Appareil
    public deleteAppareil(id: any){
      return this.http.delete(this.APAREIL+'/supprimer/'+id, {responseType: 'text'});

    }
    //Supprimer Accessoire
    public deleteAccessoire(id: any){
      return this.http.delete(this.ACCESSOIRES=+'/supprimer/'+id, {responseType: 'text'})

    }
}
