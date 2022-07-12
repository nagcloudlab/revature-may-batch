import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JerryComponent } from './jerry.component';

describe('JerryComponent', () => {
  let component: JerryComponent;
  let fixture: ComponentFixture<JerryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JerryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JerryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
