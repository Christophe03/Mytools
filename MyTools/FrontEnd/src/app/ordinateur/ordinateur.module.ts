import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { OrdinateurPageRoutingModule } from './ordinateur-routing.module';

import { OrdinateurPage } from './ordinateur.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    OrdinateurPageRoutingModule
  ],
  declarations: [OrdinateurPage]
})
export class OrdinateurPageModule {}
