import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { OrdinateurPage } from './ordinateur.page';

const routes: Routes = [
  {
    path: '',
    component: OrdinateurPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class OrdinateurPageRoutingModule {}
