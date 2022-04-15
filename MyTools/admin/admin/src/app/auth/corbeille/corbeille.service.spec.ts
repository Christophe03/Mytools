import { TestBed } from '@angular/core/testing';

import { CorbeilleService } from './corbeille.service';

describe('CorbeilleService', () => {
  let service: CorbeilleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CorbeilleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
