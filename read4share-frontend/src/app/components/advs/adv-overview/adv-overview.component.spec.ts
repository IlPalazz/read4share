import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvOverviewComponent } from './adv-overview.component';

describe('AdvOverviewComponent', () => {
  let component: AdvOverviewComponent;
  let fixture: ComponentFixture<AdvOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdvOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
