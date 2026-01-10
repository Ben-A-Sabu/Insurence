import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanSuccessComponent } from './plan-success-component';

describe('PlanSuccessComponent', () => {
  let component: PlanSuccessComponent;
  let fixture: ComponentFixture<PlanSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PlanSuccessComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanSuccessComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
