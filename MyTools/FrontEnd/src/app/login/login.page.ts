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
  loginData: any;

  constructor(private service: ServivesAppareilsService,private toastController: ToastController, private router: Router) {

   }

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }
  onLogin(form: NgForm){
    this.service.loginAtelier(form.value["email"], form.value["password"]).subscribe((resultat)=>{
      if(resultat){
        console.log(resultat);
        this.loginInfo = resultat;
        this.router.navigate(["/tabs"]);
        localStorage.setItem('isLogin', JSON.stringify(this.loginInfo));
        this.ajoute();
        form.reset();
      }else{
        this.service.loginProfessionnel(form.value["email"], form.value["password"]).subscribe((resultat)=>{
          if(resultat){
            console.log(resultat);
            this.loginInfo = resultat;
            this.router.navigate(["/tabs"]);
            localStorage.setItem('isLogin', JSON.stringify(this.loginInfo));
            this.ajoute();
            form.reset();
          }else{
            this.service.loginClient(form.value["email"], form.value["password"]).subscribe((resultat)=>{
              if(resultat){
                console.log(resultat);
                this.loginInfo = resultat;
                this.router.navigate(["/tabs"]);
                localStorage.setItem('isLogin', JSON.stringify(this.loginInfo));
                this.ajoute();
                form.reset();
              }else {
                this.router.navigate(["/login"])
                console.log("email ou mot de passe incorrect");
                this.refuse();
              }
            })
          }
        })
      }
    })
  }
  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Bienvenue sur My Tools',
      color: 'primary',
      duration: 3000
    });
    toast.present();
  }
  async refuse(){
    const toastes = await this.toastController.create({
      message: 'Email ou Mot de Passe Incorrect!',
      color: 'danger',
      duration: 3000
    });
    toastes.present();
  }
}
