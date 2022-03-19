import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModifierArticlePage } from './modifier-article.page';

const routes: Routes = [
  {
    path: '',
    component: ModifierArticlePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModifierArticlePageRoutingModule {}
