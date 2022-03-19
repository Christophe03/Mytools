import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppareilPage } from './appareil.page';

const routes: Routes = [
  {
    path: '',
    component: AppareilPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AppareilPageRoutingModule {}
