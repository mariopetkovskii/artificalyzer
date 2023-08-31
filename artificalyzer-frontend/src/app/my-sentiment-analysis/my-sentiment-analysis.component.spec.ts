import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySentimentAnalysisComponent } from './my-sentiment-analysis.component';

describe('MySentimentAnalysisComponent', () => {
  let component: MySentimentAnalysisComponent;
  let fixture: ComponentFixture<MySentimentAnalysisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MySentimentAnalysisComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MySentimentAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
