import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insurance-plans',
  standalone: false,
  templateUrl: './insurance-plans.html',
  styleUrls: ['./insurance-plans.css'],
})
export class InsurancePlans implements OnInit {
  plans: any[] = [];
  expandedPlanId: number | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.loadPlans();
  }

  loadPlans(): void {
    const data = [
      {
        id: 1,
        name: 'Silver Plan',
        description: 'Basic coverage for essential protection',
        totalPremium: 4200,
        premiumBreakdown: { basePremium: 3000, tax: 900, serviceCharge: 300 },
        features: ['Third-party liability', 'Basic accident cover']
      },
      {
        id: 2,
        name: 'Gold Plan',
        description: 'Enhanced coverage with better benefits',
        totalPremium: 6800,
        premiumBreakdown: { basePremium: 5000, tax: 1400, serviceCharge: 400 },
        features: ['Comprehensive cover', 'Zero depreciation', 'Roadside assistance']
      }
    ];

    // Important: Assign an independent activeTab to each plan
    this.plans = data.map(plan => ({ ...plan, activeTab: 'premium' }));
  }

  toggleDropdown(planId: number): void {
    this.expandedPlanId = this.expandedPlanId === planId ? null : planId;
  }

  selectTab(plan: any, tab: 'premium' | 'features'): void {
    plan.activeTab = tab;
  }

  buyPlan(plan: any): void {
    this.router.navigate(['/plan-success', 'TXN' + Math.random().toString(36).slice(2, 9)]);
  }
}