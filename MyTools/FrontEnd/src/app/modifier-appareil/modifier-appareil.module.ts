import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModifierAppareilPageRoutingModule } from './modifier-appareil-routing.module';

import { ModifierAppareilPage } from './modifier-appareil.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModifierAppareilPageRoutingModule
  ],
  declarations: [ModifierAppareilPage]
})
export class ModifierAppareilPageModule {}
