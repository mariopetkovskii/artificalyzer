import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MytranslateSentencesComponent } from './mytranslate-sentences.component';

describe('MytranslateSentencesComponent', () => {
  let component: MytranslateSentencesComponent;
  let fixture: ComponentFixture<MytranslateSentencesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MytranslateSentencesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MytranslateSentencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
