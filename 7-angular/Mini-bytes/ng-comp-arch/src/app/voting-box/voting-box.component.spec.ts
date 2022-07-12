import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VotingBoxComponent } from './voting-box.component';

describe('VotingBoxComponent', () => {
  let component: VotingBoxComponent;
  let fixture: ComponentFixture<VotingBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VotingBoxComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VotingBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
