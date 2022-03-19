import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModifierProfilPageRoutingModule } from './modifier-profil-routing.module';

import { ModifierProfilPage } from './modifier-profil.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModifierProfilPageRoutingModule
  ],
  declarations: [ModifierProfilPage]
})
export class ModifierProfilPageModule {}
