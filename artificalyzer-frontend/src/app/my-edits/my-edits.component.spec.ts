import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyEditsComponent } from './my-edits.component';

describe('MyEditsComponent', () => {
  let component: MyEditsComponent;
  let fixture: ComponentFixture<MyEditsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyEditsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyEditsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
