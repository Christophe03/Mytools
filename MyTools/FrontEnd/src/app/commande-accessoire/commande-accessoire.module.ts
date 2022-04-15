import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CommandeAccessoirePageRoutingModule } from './commande-accessoire-routing.module';

import { CommandeAccessoirePage } from './commande-accessoire.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CommandeAccessoirePageRoutingModule
  ],
  declarations: [CommandeAccessoirePage]
})
export class CommandeAccessoirePageModule {}
