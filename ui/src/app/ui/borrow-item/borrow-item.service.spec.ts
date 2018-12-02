import { TestBed, inject } from '@angular/core/testing';

import { BorrowItemService } from './borrow-item.service';

describe('BorrowItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BorrowItemService]
    });
  });

  it('should be created', inject([BorrowItemService], (service: BorrowItemService) => {
    expect(service).toBeTruthy();
  }));
});
