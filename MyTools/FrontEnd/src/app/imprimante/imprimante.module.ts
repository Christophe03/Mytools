import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ImprimantePageRoutingModule } from './imprimante-routing.module';

import { ImprimantePage } from './imprimante.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ImprimantePageRoutingModule
  ],
  declarations: [ImprimantePage]
})
export class ImprimantePageModule {}
