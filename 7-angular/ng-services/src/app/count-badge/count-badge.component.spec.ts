import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountBadgeComponent } from './count-badge.component';

describe('CountBadgeComponent', () => {
  let component: CountBadgeComponent;
  let fixture: ComponentFixture<CountBadgeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CountBadgeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CountBadgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
