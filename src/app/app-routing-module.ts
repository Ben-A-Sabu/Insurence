import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard-component/dashboard-component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login-component/login-component';
import { PlanComponent } from './plan-component/plan-component';
import { ClaimsComponent } from './claims-component/claims-component';
import { VehicleComponent } from './vehicle-component/vehicle-component';
import { InsurancePlans } from './insurance-plans/insurance-plans';
import { PlanSuccessComponent } from './plan-success-component/plan-success-component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
    { path: 'user-dashboard', component: UserDashboardComponent },
  { path: 'plan', component: PlanComponent, canActivate: [AuthGuard] },
  { path: 'claims', component: ClaimsComponent, canActivate: [AuthGuard] },
  { path: 'vehicle', component: VehicleComponent },
  { path: 'plans', component: InsurancePlans },
  { path: 'plan-success/:transactionId', component: PlanSuccessComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
