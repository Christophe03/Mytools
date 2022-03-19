import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReparationPageRoutingModule } from './reparation-routing.module';

import { ReparationPage } from './reparation.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReparationPageRoutingModule
  ],
  declarations: [ReparationPage]
})
export class ReparationPageModule {}
