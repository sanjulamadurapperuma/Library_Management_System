import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReserveItemComponent } from './reserve-item.component';

describe('ReserveItemComponent', () => {
  let component: ReserveItemComponent;
  let fixture: ComponentFixture<ReserveItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReserveItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
