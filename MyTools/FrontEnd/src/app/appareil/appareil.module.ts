import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AppareilPageRoutingModule } from './appareil-routing.module';

import { AppareilPage } from './appareil.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AppareilPageRoutingModule
  ],
  declarations: [AppareilPage]
})
export class AppareilPageModule {}
