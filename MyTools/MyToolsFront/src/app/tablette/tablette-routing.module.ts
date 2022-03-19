import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TablettePage } from './tablette.page';

const routes: Routes = [
  {
    path: '',
    component: TablettePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TablettePageRoutingModule {}
