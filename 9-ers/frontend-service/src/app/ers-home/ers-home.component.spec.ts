import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErsHomeComponent } from './ers-home.component';

describe('ErsHomeComponent', () => {
  let component: ErsHomeComponent;
  let fixture: ComponentFixture<ErsHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErsHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErsHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
