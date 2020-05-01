import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClientService, Transacion_Details, Wallet } from '../service/http-client.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {


  tlists : Transacion_Details[];
  wallet: Wallet;
  user = sessionStorage.getItem('username');
    
  constructor(
    private router: Router,
    private loginservice: AuthenticationService,
    private httpClient:HttpClient,
    private service : HttpClientService
  ) { }

  ngOnInit(): void {
  }
showTransaction(){

    console.log("i am here...");
    console.log('error')
  console.log(this.user);

  this.service.getTransactionList(this.user).subscribe( response =>{this.tlists = response;});
   //this.router.navigate(['home']);


  // this.tlists.forEach(element => {
    
  //   console.log(element.t_id);  
  // });
  

}


}
