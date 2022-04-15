import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthentiqueComponent } from './authentique.component';

describe('AuthentiqueComponent', () => {
  let component: AuthentiqueComponent;
  let fixture: ComponentFixture<AuthentiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthentiqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthentiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
