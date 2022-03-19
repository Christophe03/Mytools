import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabsPage } from './tabs.page';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'tabs/home',
    pathMatch: 'full'
  },
  {
    path: 'tabs',
    component: TabsPage,
    children:[
      {path:'home', loadChildren: ()=>import('src/app/home/home.module').then(res =>res.HomePageModule)},
      {path:'profil', loadChildren:()=>import('src/app/profil/profil.module').then(res=>res.ProfilPageModule)},
      {path: 'atelier',loadChildren: () => import('src/app/atelier/atelier.module').then( m => m.AtelierPageModule)},

    ],

  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsPageRoutingModule {}
