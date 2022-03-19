import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'home',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'ajout-article',
    loadChildren: () => import('./ajout-article/ajout-article.module').then( m => m.AjoutArticlePageModule)
  },
  {
    path: 'modifier-article',
    loadChildren: () => import('./modifier-article/modifier-article.module').then( m => m.ModifierArticlePageModule)
  },
  {
    path: 'inscription',
    loadChildren: () => import('./inscription/inscription.module').then( m => m.InscriptionPageModule)
  },
  {
    path: 'tabs',
    loadChildren: () => import('./tabs/tabs.module').then( m => m.TabsPageModule)
  },
  {
    path: 'modifier-profil',
    loadChildren: () => import('./modifier-profil/modifier-profil.module').then( m => m.ModifierProfilPageModule)
  },
  {
    path: 'achats',
    loadChildren: () => import('./achats/achats.module').then( m => m.AchatsPageModule)
  },

  {
    path: 'recherche',
    loadChildren: () => import('./recherche/recherche.module').then( m => m.RecherchePageModule)
  },
  {
    path: 'notification',
    loadChildren: ()=>import('src/app/notification/notification.module').then( res => res.NotificationPageModule)
  },

  {
    path: 'vente',
    loadChildren: ()=>import('src/app/vente/vente.module').then(res => res.VentePageModule)
  },
  {
    path: 'infos',
    loadChildren: () => import('./infos/infos.module').then( m => m.InfosPageModule)
  },
  {
    path: 'reparation',
    loadChildren: () => import('./reparation/reparation.module').then( m => m.ReparationPageModule)
  },
  {
    path: '',
    loadChildren: () => import('./bienvenu/bienvenu.module').then( m => m.BienvenuPageModule)
  },
  {
    path: 'categories',
    loadChildren: () => import('./categories/categories.module').then( m => m.CategoriesPageModule)
  },
  {
    path: 'appareil',
    loadChildren: () => import('./appareil/appareil.module').then( m => m.AppareilPageModule)
  },
  {
    path: 'accessoires',
    loadChildren: () => import('./accessoires/accessoires.module').then( m => m.AccessoiresPageModule)
  },
  {
    path: 'commande',
    loadChildren: () => import('./commande/commande.module').then( m => m.CommandePageModule)
  },
  {
    path: 'mes-article',
    loadChildren: () => import('./mes-article/mes-article.module').then( m => m.MesArticlePageModule)
  },
  {
    path: 'ordinateur',
    loadChildren: () => import('./ordinateur/ordinateur.module').then( m => m.OrdinateurPageModule)
  },
  {
    path: 'telephone',
    loadChildren: () => import('./telephone/telephone.module').then( m => m.TelephonePageModule)
  },
  {
    path: 'tablette',
    loadChildren: () => import('./tablette/tablette.module').then( m => m.TablettePageModule)
  },
  {
    path: 'televiseur',
    loadChildren: () => import('./televiseur/televiseur.module').then( m => m.TeleviseurPageModule)
  },
  {
    path: 'imprimante',
    loadChildren: () => import('./imprimante/imprimante.module').then( m => m.ImprimantePageModule)
  },
  {
    path: 'service-reparation',
    loadChildren: () => import('./service-reparation/service-reparation.module').then( m => m.ServiceReparationPageModule)
  },  {
    path: 'infos-accessoire',
    loadChildren: () => import('./infos-accessoire/infos-accessoire.module').then( m => m.InfosAccessoirePageModule)
  },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
