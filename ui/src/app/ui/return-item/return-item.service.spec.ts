import { TestBed, inject } from '@angular/core/testing';

import { ReturnItemService } from './return-item.service';

describe('ReturnItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReturnItemService]
    });
  });

  it('should be created', inject([ReturnItemService], (service: ReturnItemService) => {
    expect(service).toBeTruthy();
  }));
});
