import { TestBed } from '@angular/core/testing';

import { Guard2Guard } from './guard2.guard';

describe('Guard2Guard', () => {
  let guard: Guard2Guard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(Guard2Guard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
