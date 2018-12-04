import { TestBed, inject } from '@angular/core/testing';

import { ReserveItemService } from './reserve-item.service';

describe('ReserveItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReserveItemService]
    });
  });

  it('should be created', inject([ReserveItemService], (service: ReserveItemService) => {
    expect(service).toBeTruthy();
  }));
});
