import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModiferTechniciensPage } from './modifer-techniciens.page';

const routes: Routes = [
  {
    path: '',
    component: ModiferTechniciensPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModiferTechniciensPageRoutingModule {}
