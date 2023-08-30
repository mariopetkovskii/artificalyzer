import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyModerationScoreComponent } from './my-moderation-score.component';

describe('MyModerationScoreComponent', () => {
  let component: MyModerationScoreComponent;
  let fixture: ComponentFixture<MyModerationScoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyModerationScoreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyModerationScoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
