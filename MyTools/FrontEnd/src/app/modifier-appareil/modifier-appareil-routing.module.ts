import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModifierAppareilPage } from './modifier-appareil.page';

const routes: Routes = [
  {
    path: '',
    component: ModifierAppareilPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModifierAppareilPageRoutingModule {}
