import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InfosAccessoirePage } from './infos-accessoire.page';

const routes: Routes = [
  {
    path: '',
    component: InfosAccessoirePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class InfosAccessoirePageRoutingModule {}
