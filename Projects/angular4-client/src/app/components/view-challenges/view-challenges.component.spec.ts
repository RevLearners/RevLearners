import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewChallengesComponent } from './view-challenges.component';

describe('ViewChallengesComponent', () => {
  let component: ViewChallengesComponent;
  let fixture: ComponentFixture<ViewChallengesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewChallengesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewChallengesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
