import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TeleviseurPageRoutingModule } from './televiseur-routing.module';

import { TeleviseurPage } from './televiseur.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TeleviseurPageRoutingModule
  ],
  declarations: [TeleviseurPage]
})
export class TeleviseurPageModule {}
