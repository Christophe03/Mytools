import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TablettePageRoutingModule } from './tablette-routing.module';

import { TablettePage } from './tablette.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TablettePageRoutingModule
  ],
  declarations: [TablettePage]
})
export class TablettePageModule {}
