import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModifierAccessoirePage } from './modifier-accessoire.page';

const routes: Routes = [
  {
    path: '',
    component: ModifierAccessoirePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModifierAccessoirePageRoutingModule {}
