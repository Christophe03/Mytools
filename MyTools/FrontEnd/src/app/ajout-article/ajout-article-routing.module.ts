import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AjoutArticlePage } from './ajout-article.page';

const routes: Routes = [
  {
    path: '',
    component: AjoutArticlePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AjoutArticlePageRoutingModule {}
