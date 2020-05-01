import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { Wallet, HttpClientService } from '../service/http-client.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-bank-withdraw',
  templateUrl: './bank-withdraw.component.html',
  styleUrls: ['./bank-withdraw.component.css']
})
export class BankWithdrawComponent implements OnInit {

  user:String;
  amount:'';
  password:'';
  wallet:Wallet;
  Message:String;
  
  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private httpClient:HttpClient,
    private service : HttpClientService) { }

  ngOnInit(): void {
  }

  bankwithdrawNow(){
     
    this.user = sessionStorage.getItem('username');
    let wpin = sessionStorage.getItem('pin');
    if (wpin === this.password)
    {
      this.service.addbal(this.user,this.amount).subscribe((data)=>this.Message=data);
    }
    this.router.navigate(['home'])

  }
}
