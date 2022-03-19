import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BienvenuPageRoutingModule } from './bienvenu-routing.module';

import { BienvenuPage } from './bienvenu.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BienvenuPageRoutingModule
  ],
  declarations: [BienvenuPage]
})
export class BienvenuPageModule {}
