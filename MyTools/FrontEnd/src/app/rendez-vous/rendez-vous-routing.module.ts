import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RendezVousPage } from './rendez-vous.page';

const routes: Routes = [
  {
    path: '',
    component: RendezVousPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RendezVousPageRoutingModule {}
