import { Component, OnInit } from '@angular/core';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { FormBuilder, NgForm, FormsModule } from '@angular/forms';
import { ToastController } from '@ionic/angular';
@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.page.html',
  styleUrls: ['./inscription.page.scss'],
})
export class InscriptionPage implements OnInit {

  password_type= 'password';
  ajout: NgForm;
  body: any;
  profils: any;
  confirmer: any;
  photo: any=[];
  atelier: any;

  constructor( public service: ServivesAppareilsService, private toastController: ToastController) { }

  ngOnInit() {
  }
  view(event){
    console.log(event.target.files[0].name);
    const img = event.target.files[0];
    this.photo = img;
  }
  inscriptionForm(ajout: NgForm){
    this.body = JSON.stringify(ajout.value);
    const b= JSON.parse(this.body);
    if(b.profils==='GERANT'){
      return this.service.addAtelier(ajout.value).subscribe(data =>{
        console.log(data);
        this.atelier = data;

        this.service.imageAtelier(this.atelier.id, this.photo).subscribe(donner =>{
          console.log(donner);
        });
        if(!data){
          console.log('email existe déja');
          this.refuse();
        }
        this.ajoute();
        ajout.reset();
      });
    }
    if(b.profils==='CLIENT'){
      return this.service.addClient(ajout.value).subscribe(data=>{
        console.log(data);
        if(!data){
          console.log('email existe déja');
          this.refuse();
        }
        this.ajoute();
        ajout.reset();
      });
    }
  }
  async ajoute(){
    const toast = await this.toastController.create({
      message: 'Compte Créé avec Success.',
      color: 'success',
      duration: 3000
    });
    toast.present();
  }
  async refuse(){
    const toastes = await this.toastController.create({
      message: 'l email existe déja.',
      color: 'danger',
      duration: 3000
    });
    toastes.present();
  }
  togglePasswordMode(){
    this.password_type = this.password_type === 'text' ? 'password' : 'text';
  }

}
