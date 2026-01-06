import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-component',
  standalone:false,
  templateUrl: './dashboard-component.html',
  styleUrls: ['./dashboard-component.css']
})
export class DashboardComponent implements OnInit {

  data: any = {
    totalPlans: 0,
    activePlans: 0,
    inactivePlans: 0,
    pendingClaims: 0,
    approvedClaims: 0,
    rejectedClaims: 0
  };

  constructor(private api: ApiService, private router: Router, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    let token:string|null=null
    if(typeof window!==undefined){
       token = localStorage.getItem('token');
    }
    console.log(token);
    if (!token) {
      alert('Not logged in!');
      this.router.navigate(['/login']);
      return;
    }

    this.api.get('/insurer/dashboard', true).subscribe(
      (res: any) => {
        console.log('Dashboard data from backend:', res);
        this.data = {
          totalPlans: res.totalPlans,
          activePlans: res.activePlans,
          inactivePlans: res.inactivePlans,
          pendingClaims: res.pendingClaims,
          approvedClaims: res.approvedClaims,
          rejectedClaims: res.rejectedClaims
        };
        this.cdr.markForCheck();
      },
      (err) => {
        console.error('Error fetching dashboard:', err);
        alert('Error fetching dashboard!');
      }
    );
  }
  logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('email');
    this.router.navigate(['/login']);
  }
}