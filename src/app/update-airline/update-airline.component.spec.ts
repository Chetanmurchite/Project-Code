import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAirlineComponent } from './update-airline.component';

describe('UpdateAirlineComponent', () => {
  let component: UpdateAirlineComponent;
  let fixture: ComponentFixture<UpdateAirlineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateAirlineComponent]
    });
    fixture = TestBed.createComponent(UpdateAirlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
