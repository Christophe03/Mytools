import { TestBed } from '@angular/core/testing';

import { AccessoireService } from './accessoire.service';

describe('AccessoireService', () => {
  let service: AccessoireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccessoireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
