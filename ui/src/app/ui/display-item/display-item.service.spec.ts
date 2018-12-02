import { TestBed, inject } from '@angular/core/testing';

import { DisplayItemService } from './display-item.service';

describe('DisplayItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DisplayItemService]
    });
  });

  it('should be created', inject([DisplayItemService], (service: DisplayItemService) => {
    expect(service).toBeTruthy();
  }));
});
