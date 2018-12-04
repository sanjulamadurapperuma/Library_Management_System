import { TestBed, inject } from '@angular/core/testing';

import { GenerateReportService } from './generate-report.service';

describe('GenerateReportService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GenerateReportService]
    });
  });

  it('should be created', inject([GenerateReportService], (service: GenerateReportService) => {
    expect(service).toBeTruthy();
  }));
});
