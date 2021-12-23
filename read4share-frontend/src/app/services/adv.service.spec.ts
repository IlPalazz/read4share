import { TestBed } from '@angular/core/testing';

import { AdvService } from './adv.service';

describe('AdvsService', () => {
  let service: AdvService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdvService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
