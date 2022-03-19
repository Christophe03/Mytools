import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AchatsPageRoutingModule } from './achats-routing.module';

import { AchatsPage } from './achats.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AchatsPageRoutingModule
  ],
  declarations: [AchatsPage]
})
export class AchatsPageModule {}
