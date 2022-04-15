import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MesAccessoirePageRoutingModule } from './mes-accessoire-routing.module';

import { MesAccessoirePage } from './mes-accessoire.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MesAccessoirePageRoutingModule
  ],
  declarations: [MesAccessoirePage]
})
export class MesAccessoirePageModule {}
