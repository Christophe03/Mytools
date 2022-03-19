import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ModiferTechniciensPage } from './modifer-techniciens.page';

describe('ModiferTechniciensPage', () => {
  let component: ModiferTechniciensPage;
  let fixture: ComponentFixture<ModiferTechniciensPage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ModiferTechniciensPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ModiferTechniciensPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
