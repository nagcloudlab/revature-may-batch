import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErsRequestFormComponent } from './ers-request-form.component';

describe('ErsRequestFormComponent', () => {
  let component: ErsRequestFormComponent;
  let fixture: ComponentFixture<ErsRequestFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErsRequestFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErsRequestFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
