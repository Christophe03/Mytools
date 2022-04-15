import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AjoutProfessionnelPage } from './ajout-professionnel.page';

const routes: Routes = [
  {
    path: '',
    component: AjoutProfessionnelPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AjoutProfessionnelPageRoutingModule {}
