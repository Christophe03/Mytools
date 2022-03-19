import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { NgForm } from '@angular/forms';
import { ToastController } from '@ionic/angular';
@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  loginInfo:any

  constructor(private service: ServivesAppareilsService, private toast: ToastController, private router: Router) { }

  ngOnInit() {
  }
  onLogin(form: NgForm){
    this.service.loginAtelier(form.value["email"], form.value["password"]).subscribe((resultat)=>{
      if(resultat){
        console.log(resultat);
        this.loginInfo = resultat;
        this.router.navigate(["/tabs"]);
        localStorage.setItem('isLogin', JSON.stringify(this.loginInfo));
      }else{
        this.service.loginProfessionnel(form.value["email"], form.value["password"]).subscribe((resultat)=>{
          if(resultat){
            console.log(resultat);
            this.loginInfo = resultat;
            this.router.navigate(["/tabs"]);
            localStorage.setItem('isLogin', JSON.stringify(this.loginInfo));
          }else{
            this.service.loginClient(form.value["email"], form.value["password"]).subscribe((resultat)=>{
              if(resultat){
                console.log(resultat);
                this.loginInfo = resultat;
                this.router.navigate(["/tabs"]);
                localStorage.setItem('isLogin', JSON.stringify(this.loginInfo));
              }else {
                this.router.navigate(["/login"])
                console.log("email ou mot de passe incorrect");
              }
            })
          }
        })
      }
    })
  }
}
