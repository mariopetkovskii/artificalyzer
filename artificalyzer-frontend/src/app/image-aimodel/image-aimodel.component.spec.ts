import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageAimodelComponent } from './image-aimodel.component';

describe('ImageAimodelComponent', () => {
  let component: ImageAimodelComponent;
  let fixture: ComponentFixture<ImageAimodelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageAimodelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageAimodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
