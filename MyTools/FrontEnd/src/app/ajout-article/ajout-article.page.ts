import { Component, OnInit } from '@angular/core';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { FormBuilder, NgForm, FormsModule } from '@angular/forms';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-ajout-article',
  templateUrl: './ajout-article.page.html',
  styleUrls: ['./ajout-article.page.scss'],
})
export class AjoutArticlePage implements OnInit {
  ajout: NgForm;
  body: any;
  articleType: any;
  photo: any=[];
  message: any;
  imagePath: any;
  imgURL: any;
  services: any;
  files: any;
  appareil: any;
  accessoires: any;
  loginData: any;
  profils: string;

  constructor(
    private servive: ServivesAppareilsService, private toastController: ToastController) {}

  ngOnInit() {
    this.loginData=JSON.parse(localStorage.getItem('isLogin'));
    console.log(this.loginData);
  }

  view(event){
    console.log(event.target.files[0].name);
    const img = event.target.files[0];
    this.photo = img;
  }
  articleForm(ajout: NgForm){
    this.body = JSON.stringify(ajout.value);
    const b= JSON.parse(this.body);
    console.log(this.loginData.profils);

    if(b.articleType==='APPAREIL'){
      return this.servive.addAppareil(ajout.value,this.loginData.profils,this.loginData.id).subscribe(data =>{
        console.log(data);
        this.appareil = data;

        this.servive.addImages(this.appareil.id, this.photo).subscribe(donner =>{
        console.log(donner);
        ajout.reset();
        this.ajoute();
        });

      });
    }
    if(b.articleType==='ACCESSOIRES'){
      return this.servive.addAccessoire(ajout.value,this.loginData.profils,this.loginData.id).subscribe(data =>{
        console.log(data);
        this.accessoires = data;

        this.servive.imageAccessoire(this.accessoires.id, this.photo).subscribe(data1 =>{
          console.log(data1);
          ajout.reset();
          this.ajoute();
        });
      });
    }
  }
  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Article Ajouter avec Success',
      color: 'primary',
      duration: 3000
    });
    toast.present();
  }
  async refuse(){
    const toast = await this.toastController.create({
      message: 'Ajout Refuser renseigner correctement les information ',
      color: 'danger',
      duration: 3000
    });
    toast.present();

  }
}



