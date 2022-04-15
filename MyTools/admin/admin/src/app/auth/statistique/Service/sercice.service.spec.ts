import { TestBed } from '@angular/core/testing';

import { SerciceService } from './sercice.service';

describe('SerciceService', () => {
  let service: SerciceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SerciceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
