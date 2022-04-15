import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthentiqueComponent } from 'src/authentique/authentique.component';
import { AuthentificationGuard } from './guard/authentification.guard';

const routes: Routes = [
  { path: '', component: AuthentiqueComponent},
  { path: 'login', component: AuthentiqueComponent  },
  {
    path:'tableau', loadChildren:() => import('./auth/auth.module')
    .then(m => m.AuthModule),canActivate: [AuthentificationGuard] 
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
