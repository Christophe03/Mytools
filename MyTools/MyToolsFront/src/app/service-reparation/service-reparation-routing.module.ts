import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ServiceReparationPage } from './service-reparation.page';

const routes: Routes = [
  {
    path: '',
    component: ServiceReparationPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ServiceReparationPageRoutingModule {}
