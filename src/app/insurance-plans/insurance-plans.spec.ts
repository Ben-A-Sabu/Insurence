import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsurancePlans } from './insurance-plans';

describe('InsurancePlans', () => {
  let component: InsurancePlans;
  let fixture: ComponentFixture<InsurancePlans>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsurancePlans]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsurancePlans);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
