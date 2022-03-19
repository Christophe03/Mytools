import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModifierArticlePageRoutingModule } from './modifier-article-routing.module';

import { ModifierArticlePage } from './modifier-article.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModifierArticlePageRoutingModule
  ],
  declarations: [ModifierArticlePage]
})
export class ModifierArticlePageModule {}
