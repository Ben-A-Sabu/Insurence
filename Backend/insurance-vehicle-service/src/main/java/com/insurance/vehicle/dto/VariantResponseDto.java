package com.insurance.vehicle.dto;

import com.insurance.vehicle.constants.FuelType;

public class VariantResponseDto {
	
	  private Long id;
	  private String name; 
	 private FuelType fuelType;   

	    
	    public VariantResponseDto(Long id, String name, FuelType fuelType) {
			super();
			this.id = id;
			this.name = name;
			this.fuelType = fuelType;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public FuelType getFuelType() {
			return fuelType;
		}
		public void setFuelType(FuelType fuelType) {
			this.fuelType = fuelType;
		}
	
	
}
