import { TestBed } from '@angular/core/testing';

import { FooService } from './foo.service';

describe('FooService', () => {
  let service: FooService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FooService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
