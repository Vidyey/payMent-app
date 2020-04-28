import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankDepositComponent } from './bank-deposit.component';

describe('BankDepositComponent', () => {
  let component: BankDepositComponent;
  let fixture: ComponentFixture<BankDepositComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankDepositComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankDepositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
