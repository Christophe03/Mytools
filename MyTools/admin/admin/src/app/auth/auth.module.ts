
import { FormsModule } from '@angular/forms';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { AuthRoutingModule } from './auth-routing.module';
import { TableauComponent } from './tableau/tableau.component';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { CommandeComponent } from './commande/lister-commande/commande.component';

import  { BilanComponent } from './bilan/bilan.component';
import { HeaderComponent } from './header/header.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { SidenavComponent } from './sidenav/sidenav.component';
import { StatistiqueComponent } from './statistique/statistique.component';
import { VenteComponent } from './vente/lister-vente/vente.component';
import { NgChartsModule } from 'ng2-charts';
import { AccessoireComponent } from './accessoire/lister-accessoire/accessoire.component'; 
import { CorbeilleComponent } from './corbeille/corbeille.component';

import { AppareilComponent } from './appareil/lister-appareil/appareil.component';
import { Ng2GoogleChartsModule } from 'ng2-google-charts';

import { HttpClientModule } from '@angular/common/http';

import { AtelierComponent } from './atelier/lister-atelier/atelier.component';
import { DashboardComponent } from './dashboard/dashboard.component';
@NgModule({
  declarations: [
    TableauComponent,
    CommandeComponent,
     DashboardComponent,
    BilanComponent,
    HeaderComponent,
    SidenavComponent,
    StatistiqueComponent,
    VenteComponent,
    AccessoireComponent,
    AppareilComponent,
    
    CorbeilleComponent,
   
    AtelierComponent,
    
  ],
  imports: [
    CommonModule,
    FormsModule,
    AuthRoutingModule,
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    HttpClientModule,
    NgChartsModule,
    MatFormFieldModule,
    Ng2GoogleChartsModule,
    
    
    
   
    
    
    
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [],
})
export class AuthModule { }
