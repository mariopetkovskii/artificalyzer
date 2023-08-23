import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditsAimodelComponent } from './edits-aimodel.component';

describe('EditsAimodelComponent', () => {
  let component: EditsAimodelComponent;
  let fixture: ComponentFixture<EditsAimodelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditsAimodelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditsAimodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
