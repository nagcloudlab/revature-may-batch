import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactsHomeComponent } from './contacts-home.component';

describe('ContactsHomeComponent', () => {
  let component: ContactsHomeComponent;
  let fixture: ComponentFixture<ContactsHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactsHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContactsHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
