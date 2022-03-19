import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TeleviseurPage } from './televiseur.page';

const routes: Routes = [
  {
    path: '',
    component: TeleviseurPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TeleviseurPageRoutingModule {}
