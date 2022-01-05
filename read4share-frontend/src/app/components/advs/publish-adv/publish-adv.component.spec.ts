import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishAdvComponent } from './publish-adv.component';

describe('PublishAdvComponent', () => {
  let component: PublishAdvComponent;
  let fixture: ComponentFixture<PublishAdvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublishAdvComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PublishAdvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
