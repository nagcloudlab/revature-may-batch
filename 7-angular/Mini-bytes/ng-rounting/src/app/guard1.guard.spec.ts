import { TestBed } from '@angular/core/testing';

import { Guard1Guard } from './guard1.guard';

describe('Guard1Guard', () => {
  let guard: Guard1Guard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(Guard1Guard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
