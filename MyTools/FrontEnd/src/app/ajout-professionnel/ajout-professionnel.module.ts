import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AjoutProfessionnelPageRoutingModule } from './ajout-professionnel-routing.module';

import { AjoutProfessionnelPage } from './ajout-professionnel.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AjoutProfessionnelPageRoutingModule
  ],
  declarations: [AjoutProfessionnelPage]
})
export class AjoutProfessionnelPageModule {}
