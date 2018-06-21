import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateManualComponent } from './create-manual.component';

describe('CreateManualComponent', () => {
  let component: CreateManualComponent;
  let fixture: ComponentFixture<CreateManualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateManualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateManualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
