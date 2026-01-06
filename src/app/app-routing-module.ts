import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard-component/dashboard-component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login-component/login-component';
import { PlanComponent } from './plan-component/plan-component';
import { ClaimsComponent } from './claims-component/claims-component';

const routes: Routes = [{path:'login',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent,canActivate:[AuthGuard]},
  { path: 'plan', component: PlanComponent, canActivate: [AuthGuard] },
   { path: 'claims', component: ClaimsComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: 'login' ,pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
