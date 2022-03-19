import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MesArticlePageRoutingModule } from './mes-article-routing.module';

import { MesArticlePage } from './mes-article.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MesArticlePageRoutingModule
  ],
  declarations: [MesArticlePage]
})
export class MesArticlePageModule {}
