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

  rtos: any[] = [];
  brands: any[] = [];
  models: any[] = [];
  fuelTypes: string[] = [];
  variants: any[] = [];

  selectedRto: any;
  selectedBrand: any;
  selectedModel: any;
  selectedFuel: string | undefined;
  selectedVariant: any;
entryMode: any;

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    //this.api.getRtos().subscribe(r => this.rtos = r);
   // this.api.getBrands().subscribe(b => this.brands = b);
  }

  fetchVehicle() {
    if (!this.vehicleNumber) {
      alert('Enter vehicle number');
      return;
    }

    // this.api.getVehicleByNumber(this.vehicleNumber).subscribe({
    //   next: res => {
    //     this.autoPopulated = true;
    //     this.selectedRto = res.rto;
    //     this.selectedBrand = res.brand;
    //     this.selectedModel = res.model;
    //     this.selectedFuel = res.fuelType;
    //     this.selectedVariant = res.variant;
    //   },
    //   error: () => {
    //     alert('Vehicle not found. Please enter manually.');
    //     this.autoPopulated = false;
    //   }
    // });
  }

  onBrandChange() {
   // this.api.getModelsByBrand(this.selectedBrand.id)
      //.subscribe(m => this.models = m);
  }

  onModelChange() {
   // this.api.getFuelTypes(this.selectedModel.id)
     // .subscribe(f => this.fuelTypes = f);
  }

  onFuelChange() {
    //this.api.getVariants(this.selectedModel.id, this.selectedFuel)
      //.subscribe(v => this.variants = v);
  }

  continue() {
    console.log('Vehicle Final Selection', {
      rto: this.selectedRto,
      brand: this.selectedBrand,
      model: this.selectedModel,
      fuel: this.selectedFuel,
      variant: this.selectedVariant
    });
  }
}