import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SentenceStatementsComponent } from './sentence-statements.component';

describe('SentenceStatementsComponent', () => {
  let component: SentenceStatementsComponent;
  let fixture: ComponentFixture<SentenceStatementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SentenceStatementsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SentenceStatementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
