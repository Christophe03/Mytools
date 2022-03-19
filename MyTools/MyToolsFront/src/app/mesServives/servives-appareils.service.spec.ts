import { TestBed } from '@angular/core/testing';

import { ServivesAppareilsService } from './servives-appareils.service';

describe('ServivesAppareilsService', () => {
  let service: ServivesAppareilsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServivesAppareilsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
