import { VenteComponent } from './vente/lister-vente/vente.component';

import { CommandeComponent } from './commande/lister-commande/commande.component';
import { AtelierComponent } from './atelier/lister-atelier/atelier.component';
import { AppareilComponent } from './appareil/lister-appareil/appareil.component';
import { AccessoireComponent } from './accessoire/lister-accessoire/accessoire.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BilanComponent } from './bilan/bilan.component';
import { CorbeilleComponent } from './corbeille/corbeille.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { StatistiqueComponent } from './statistique/statistique.component';
import { TableauComponent } from './tableau/tableau.component';
import { AuthentificationGuard } from '../guard/authentification.guard';


const routes: Routes = [
  {
    path: '', component: TableauComponent, children:
    [      
      { path: '', component: DashboardComponent},
      { path: 'dashboard', component: DashboardComponent ,canActivate: [AuthentificationGuard]  },
      { path:'atelier', component:AtelierComponent,canActivate: [AuthentificationGuard] },
      { path:'appareil', component:AppareilComponent,canActivate: [AuthentificationGuard] },
      { path:'accessoire', component: AccessoireComponent,canActivate: [AuthentificationGuard] },
      { path:'vente', component: VenteComponent,canActivate: [AuthentificationGuard] },
      { path:'commande', component: CommandeComponent,canActivate: [AuthentificationGuard] },
      { path:'bilan', component: BilanComponent,canActivate: [AuthentificationGuard] },
      { path:'statistique', component: StatistiqueComponent,canActivate: [AuthentificationGuard] },
      { path:'corbeille', component:CorbeilleComponent,canActivate: [AuthentificationGuard] },
   
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
