import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { InfosAccessoirePageRoutingModule } from './infos-accessoire-routing.module';

import { InfosAccessoirePage } from './infos-accessoire.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    InfosAccessoirePageRoutingModule
  ],
  declarations: [InfosAccessoirePage]
})
export class InfosAccessoirePageModule {}
