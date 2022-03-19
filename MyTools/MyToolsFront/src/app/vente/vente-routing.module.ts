import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VentePage } from './vente.page';

const routes: Routes = [
  {
    path: '',
    component: VentePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VentePageRoutingModule {}
