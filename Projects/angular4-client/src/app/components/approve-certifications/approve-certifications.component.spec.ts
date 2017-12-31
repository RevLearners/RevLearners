import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveCertificationsComponent } from './approve-certifications.component';

describe('ApproveCertificationsComponent', () => {
  let component: ApproveCertificationsComponent;
  let fixture: ComponentFixture<ApproveCertificationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveCertificationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveCertificationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
