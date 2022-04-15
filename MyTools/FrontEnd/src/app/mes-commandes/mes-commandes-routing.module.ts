import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MesCommandesPage } from './mes-commandes.page';

const routes: Routes = [
  {
    path: '',
    component: MesCommandesPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MesCommandesPageRoutingModule {}
