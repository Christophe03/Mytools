import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModiferTechniciensPageRoutingModule } from './modifer-techniciens-routing.module';

import { ModiferTechniciensPage } from './modifer-techniciens.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModiferTechniciensPageRoutingModule
  ],
  declarations: [ModiferTechniciensPage]
})
export class ModiferTechniciensPageModule {}
