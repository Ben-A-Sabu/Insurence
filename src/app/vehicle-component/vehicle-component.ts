import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-vehicle-component',
  standalone: false,
  templateUrl: './vehicle-component.html',
  styleUrl: './vehicle-component.css',
})
export class VehicleComponent implements OnInit {
  vehicleNumber = '';
  autoPopulated = false;
  isLoading = false;
  entryMode: 'AUTO' | 'MANUAL' = 'AUTO';

  rtos: any[] = [];
  brands: any[] = [];
  models: any[] = [];
  fuelTypes: string[] = [];
  variants: any[] = [];

  selectedRto: any = null;
  selectedBrand: any = null;
  selectedModel: any = null;
  selectedFuel: string | undefined = undefined;
  selectedVariant: any = null;

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    // Load initial data for Manual mode
    // this.api.getRtos().subscribe(r => this.rtos = r);
    // this.api.getBrands().subscribe(b => this.brands = b);
  }

  fetchVehicle() {
    if (!this.vehicleNumber) return;
    
    this.isLoading = true;
    // Simulate API Call
    setTimeout(() => {
      // Logic to fetch from DB
      // this.api.getVehicleByNumber(this.vehicleNumber).subscribe(...)
      this.autoPopulated = true;
      this.isLoading = false;
      
      // Mocking a result for demo
      this.selectedBrand = { name: 'Maruti Suzuki' };
      this.selectedModel = { name: 'Swift' };
    }, 1500);
  }

  // Logic to check if we can proceed
  isFormValid(): boolean {
    if (this.entryMode === 'AUTO') {
      return this.autoPopulated; // Only active if fetch was successful
    } else {
      // All manual fields must be truthy
      return !!(this.selectedRto && this.selectedBrand && this.selectedModel && this.selectedFuel && this.selectedVariant);
    }
  }

  onBrandChange() { /* API call for models */ }
  onModelChange() { /* API call for fuels */ }
  onFuelChange() {  /* API call for variants */ }

  continue() {
    if(this.isFormValid()) {
      console.log('Proceeding with:', this.vehicleNumber || this.selectedVariant);
    }
  }
}