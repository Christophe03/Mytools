import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MesArticlePage } from './mes-article.page';

const routes: Routes = [
  {
    path: '',
    component: MesArticlePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MesArticlePageRoutingModule {}
