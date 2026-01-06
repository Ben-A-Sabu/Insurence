import { ChangeDetectorRef, Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-claims-component',
  standalone: false,
  templateUrl: './claims-component.html',
  styleUrl: './claims-component.css',
})
export class ClaimsComponent {
  pendingClaims: any[] = [];
  approvedClaims: any[] = [];
  rejectedClaims: any[] = [];

  constructor(private api: ApiService,private cdr: ChangeDetectorRef,private router:Router) {}
  goback(){
    this.router.navigate(['/dashboard']);
  }
  ngOnInit(): void {
    this.loadClaims();
  }

  loadClaims() {
    this.api.get('/insurer/claims', true).subscribe((res: any[]) => {
      console.log('Claims:', res);

      this.pendingClaims = res.filter(c => c.status === 'PENDING');
      this.approvedClaims = res.filter(c => c.status === 'APPROVED');
      console.log(this.approvedClaims.length);
      this.rejectedClaims = res.filter(c => c.status === 'REJECTED');
      this.cdr.markForCheck();
    });
  }

  approve(id: number) {
    const remark = 'Approved by insurer';

    this.api.put(
      `/insurer/claims/${id}/approve?remark=${encodeURIComponent(remark)}`,
      {},
      true
    ).subscribe(() => {
      this.loadClaims();
    });
  }
  reject(id: number) {
    const remark = 'Rejected by insurer';

    this.api.put(
      `/insurer/claims/${id}/reject?remark=${encodeURIComponent(remark)}`,
      {},
      true
    ).subscribe(() => {
      this.loadClaims();
    });
  }
}
