import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CorbeilleService {

  url = environment.URL;
  constructor(private http: HttpClient) { }

  restoreAtelier(id:any, data:any){
    return this.http.put(this.url+"/atelier/restore/"+id, data);
  }
  restoreAccessoire(id:any, data:any){
    return this.http.put(this.url+"/accessoire/restore/"+id, data);
  }
  restoreAppareil(id:any, data:any){
    return this.http.put(this.url+"/appareil/restore/"+id, data);
  }
}
