import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ImprimantePage } from './imprimante.page';

const routes: Routes = [
  {
    path: '',
    component: ImprimantePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ImprimantePageRoutingModule {}
