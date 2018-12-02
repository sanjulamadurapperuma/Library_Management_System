import { TestBed, inject } from '@angular/core/testing';

import { DeleteItemService } from './delete-item.service';

describe('DeleteItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DeleteItemService]
    });
  });

  it('should be created', inject([DeleteItemService], (service: DeleteItemService) => {
    expect(service).toBeTruthy();
  }));
});
