import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';





@Component({
  selector: 'app-plan-success',
  templateUrl: './plan-success-component.html',
  styleUrls: ['./plan-success-component.css'],
  standalone: false,
})
export class PlanSuccessComponent implements OnInit {

  planName!: string;
  premium!: number;
  transactionId!: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.transactionId = this.route.snapshot.paramMap.get('transactionId')!;

    if (!this.transactionId) {
      this.router.navigate(['/']);
      return;
    }

    /*
     🔹 BACKEND API CALL 🔹

     this.purchaseService
       .getPurchaseDetails(this.transactionId)
       .subscribe({
         next: (response) => {
           this.planName = response.planName;
           this.premium = response.premium;
         },
         error: () => this.router.navigate(['/'])
       });
    */

    // Mock response
    this.planName = 'Gold Plan';
    this.premium = 6800;
  }

  goHome(): void {
    this.router.navigate(['/']);
  }
}
