import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Wallet } from './http-client.service';
import { Observable, throwError } from 'rxjs';
import {retry, catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  wallet : Wallet;
  

  constructor(private httpClient:HttpClient) { }


  authenticate(username, password) {

    let resp = this.getWalletDetail(username);
    resp.subscribe((data)=>this.wallet=data);
    
    if (username === this.wallet.mobile_Number && password === this.wallet.wallet_Pin) {
    
      sessionStorage.setItem('username', username)
      sessionStorage.setItem('pin',this.wallet.wallet_Pin)
      sessionStorage.setItem('amount', this.wallet.wallet_Ammount)
      sessionStorage.setItem('person', this.wallet.name)
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    //console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  public getWalletDetail(username) :Observable<any>
  { 
      return this.httpClient.get("http://localhost:9090/getUser/"+username )
      .pipe(
        retry(1),
        catchError(this.handleError)
      ) 
  } 

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      //Get client-side error
      errorMessage = "client side error :-"+error.error.message;
    } else {
      //Get server-side error
      errorMessage = `"user not found"`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

}
