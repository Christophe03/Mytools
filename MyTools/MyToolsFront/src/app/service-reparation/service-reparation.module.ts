import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ServiceReparationPageRoutingModule } from './service-reparation-routing.module';

import { ServiceReparationPage } from './service-reparation.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ServiceReparationPageRoutingModule
  ],
  declarations: [ServiceReparationPage]
})
export class ServiceReparationPageModule {}
