import { Component, OnInit } from '@angular/core';
import { Wallet, HttpClientService } from '../service/http-client.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  
  receiver:'';
  amount:'';
  password:'';
  caption:'';
  wallet:Wallet;
  Message:String;
  
  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private httpClient:HttpClient,
    private service : HttpClientService) { }

  ngOnInit(): void {
  }

  user = sessionStorage.getItem('username');
  wpin = sessionStorage.getItem('pin')
  

  public fundtransferNow(){

    
    
      if (this.wpin === this.password)
    {
      this.service.trasfer(this.user,this.receiver,this.amount,this.caption).subscribe((data)=>this.Message=data);
    }

    alert("sucessful payment trasfer");
    this.router.navigate(['home'])

  }

}
