import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AccessoiresPage } from './accessoires.page';

const routes: Routes = [
  {
    path: '',
    component: AccessoiresPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AccessoiresPageRoutingModule {}
