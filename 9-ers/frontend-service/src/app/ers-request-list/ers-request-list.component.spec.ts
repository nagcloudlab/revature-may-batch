import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErsRequestListComponent } from './ers-request-list.component';

describe('ErsRequestListComponent', () => {
  let component: ErsRequestListComponent;
  let fixture: ComponentFixture<ErsRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErsRequestListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErsRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
