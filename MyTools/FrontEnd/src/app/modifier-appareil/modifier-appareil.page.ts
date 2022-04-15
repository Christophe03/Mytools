import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalController, NavParams, ToastController } from '@ionic/angular';
import { ServivesAppareilsService } from '../mesServives/servives-appareils.service';
import { Appareil } from '../models/appareil';

@Component({
  selector: 'app-modifier-appareil',
  templateUrl: './modifier-appareil.page.html',
  styleUrls: ['./modifier-appareil.page.scss'],
})
export class ModifierAppareilPage implements OnInit {
  photo: any=[];
  constructor(private service: ServivesAppareilsService, private Toast: ToastController, private navigation: NavParams) { }
  view(event){
    console.log(event.target.files[0].name);
    const img = event.target.files[0];
    this.photo = img;
  }
  ngOnInit() {
  }

}
