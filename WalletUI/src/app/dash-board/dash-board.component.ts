import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { HttpClientService, Wallet } from '../service/http-client.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {

  amount:String;
  wallet:Wallet;

  constructor(
    public loginService: AuthenticationService,
    private router: Router,
    
  
  ) { 
    
  }

  ngOnInit(): void {
    this.amount = this.refreshamt();
    
  }

  public routePayment(){

    if (this.loginService.isUserLoggedIn()
    ) {
      this.router.navigate(['fundTransfer']);
      
    } else
    this.router.navigate(['login']);
  }
  public routedeposit(){

    if (this.loginService.isUserLoggedIn()
    ) {
      this.router.navigate(['BankDeposit']);
      
    } else
    this.router.navigate(['login']);
  }
  public routeWithdraw(){

    if (this.loginService.isUserLoggedIn()
    ) {
      this.router.navigate(['addBalanceToWallet']);
      
    } else
    this.router.navigate(['login']);
  }
  public routehistry(){

    if (this.loginService.isUserLoggedIn()
    ) {
      this.router.navigate(['showTransaction']);
      
    } else
    this.router.navigate(['login']);
  }
  public routelogout(){

    if (this.loginService.isUserLoggedIn()
    ) {
      this.router.navigate(['logout']);
      
    } else
    this.router.navigate(['login']);
  }

  public refreshamt(){

    let user = sessionStorage.getItem('username');
    this.loginService.getWalletDetail(user).subscribe((data)=>this.wallet=data);
    this.amount = this.wallet.wallet_Ammount;

    return this.amount;

  }

}
