import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VentePageRoutingModule } from './vente-routing.module';

import { VentePage } from './vente.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VentePageRoutingModule
  ],
  declarations: [VentePage]
})
export class VentePageModule {}
