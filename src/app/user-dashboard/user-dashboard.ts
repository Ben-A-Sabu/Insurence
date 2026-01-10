import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  standalone: false,
  templateUrl: './user-dashboard.html',
  styleUrls: ['./user-dashboard.css']
})
export class UserDashboardComponent implements OnInit {
  profileForm: FormGroup;
  isEditing = false;
  tempData: any; // To store values before editing

  purchasedPlans = [
    { category: 'Health', name: 'Family Gold Plan', policyId: 'INS-101', expiryDate: '20-Dec-2026' },
    { category: 'Auto', name: 'Car Comprehensive', policyId: 'CAR-505', expiryDate: '15-Jan-2027' }
  ];

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.profileForm = this.fb.group({
      username: ['JohnDoe', Validators.required],
      email: ['john@example.com', [Validators.required, Validators.email]]
    });
  }

  ngOnInit(): void {}

  toggleEdit(): void {
    this.isEditing = true;
    this.tempData = { ...this.profileForm.value }; // Create a backup
  }

  cancelEdit(): void {
    this.isEditing = false;
    if (this.tempData) {
      this.profileForm.patchValue(this.tempData); // Restore backup
    }
  }

  onSaveProfile(): void {
    if (this.profileForm.valid) {
      const updatedProfile = this.profileForm.value;
      
      this.http.put('your-api-endpoint/profile', updatedProfile).subscribe({
        next: (response) => {
          this.isEditing = false;
          this.profileForm.markAsPristine();
          alert('Profile updated successfully!');
        },
        error: (err) => {
          alert('Error saving profile');
          this.cancelEdit();
        }
      });
    }
  }

  navigateToShop() {
   this.router.navigate(['/vehicle']);
  }
}