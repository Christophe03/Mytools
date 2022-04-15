import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
host =environment.URL;
  constructor(private http:HttpClient) { }

  login(email, password){
    return this.http.get(this.host+"/superAdmin/connexion/"+email+"&"+password);
  }
}
