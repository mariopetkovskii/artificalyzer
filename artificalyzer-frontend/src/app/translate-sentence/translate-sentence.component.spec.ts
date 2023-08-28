import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranslateSentenceComponent } from './translate-sentence.component';

describe('TranslateSentenceComponent', () => {
  let component: TranslateSentenceComponent;
  let fixture: ComponentFixture<TranslateSentenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TranslateSentenceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TranslateSentenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
