import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPersonaComponent } from './components/add-persona/add-persona.component';
import { ConsultFacturasComponent } from './components/consult-facturas/consult-facturas.component';
import { IndexComponent } from './components/index/index.component';

export const ROUTES: Routes = [
    { path: 'add-persona', component: AddPersonaComponent },
    { path: 'consult-facturas', component: ConsultFacturasComponent },
    { path: 'index', component: IndexComponent },
    { path: '', pathMatch: 'full', redirectTo: '/' },
    { path: '**', pathMatch: 'full', redirectTo: '/' }
];

@NgModule({
    imports: [RouterModule.forRoot(ROUTES)],
    exports: [RouterModule]
  })
  export class AppRoutingModule {}
