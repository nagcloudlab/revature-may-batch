import { TestBed } from '@angular/core/testing';

import { Guard3Guard } from './guard3.guard';

describe('Guard3Guard', () => {
  let guard: Guard3Guard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(Guard3Guard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
