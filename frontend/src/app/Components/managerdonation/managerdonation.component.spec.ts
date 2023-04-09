import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerdonationComponent } from './managerdonation.component';

describe('ManagerdonationComponent', () => {
  let component: ManagerdonationComponent;
  let fixture: ComponentFixture<ManagerdonationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerdonationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManagerdonationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
