import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MesAccessoirePage } from './mes-accessoire.page';

const routes: Routes = [
  {
    path: '',
    component: MesAccessoirePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MesAccessoirePageRoutingModule {}
