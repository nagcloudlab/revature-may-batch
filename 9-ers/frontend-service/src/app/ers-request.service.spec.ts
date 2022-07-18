import { TestBed } from '@angular/core/testing';

import { ErsRequestService } from './ers-request.service';

describe('ErsRequestService', () => {
  let service: ErsRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ErsRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
