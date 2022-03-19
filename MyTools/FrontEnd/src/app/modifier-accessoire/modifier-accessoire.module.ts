import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModifierAccessoirePageRoutingModule } from './modifier-accessoire-routing.module';

import { ModifierAccessoirePage } from './modifier-accessoire.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModifierAccessoirePageRoutingModule
  ],
  declarations: [ModifierAccessoirePage]
})
export class ModifierAccessoirePageModule {}
