import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import {HttpClientModule} from '@angular/common/http';
import { HttpClientService } from './service/http-client.service';
import {FormsModule} from '@angular/forms';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { BankDepositComponent } from './bank-deposit/bank-deposit.component';
import { BankWithdrawComponent } from './bank-withdraw/bank-withdraw.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AuthenticationService } from './service/authentication.service';
import { DashBoardComponent } from './dash-board/dash-board.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    FundTransferComponent,
    BankDepositComponent,
    BankWithdrawComponent,
    TransactionHistoryComponent,
    LoginComponent,
    LogoutComponent,
    HeaderComponent,
    FooterComponent,
    DashBoardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [HttpClientService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
