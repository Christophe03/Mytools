import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AccessoiresPageRoutingModule } from './accessoires-routing.module';

import { AccessoiresPage } from './accessoires.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AccessoiresPageRoutingModule
  ],
  declarations: [AccessoiresPage]
})
export class AccessoiresPageModule {}
