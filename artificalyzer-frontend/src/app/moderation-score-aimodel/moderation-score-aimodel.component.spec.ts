import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModerationScoreAimodelComponent } from './moderation-score-aimodel.component';

describe('ModerationScoreAimodelComponent', () => {
  let component: ModerationScoreAimodelComponent;
  let fixture: ComponentFixture<ModerationScoreAimodelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModerationScoreAimodelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModerationScoreAimodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
