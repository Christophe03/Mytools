import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModifierProfilPage } from './modifier-profil.page';

const routes: Routes = [
  {
    path: '',
    component: ModifierProfilPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModifierProfilPageRoutingModule {}
