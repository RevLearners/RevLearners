import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitCertificationComponent } from './submit-certification.component';

describe('SubmitCertificationComponent', () => {
  let component: SubmitCertificationComponent;
  let fixture: ComponentFixture<SubmitCertificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitCertificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitCertificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
