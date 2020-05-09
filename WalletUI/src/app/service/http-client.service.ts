import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';

export class Wallet{
  constructor(
    public mobile_Number:string,
		public email_id:string,
    public adhar_Number:string,
    public name:string,
    public wallet_Ammount : string,
    public wallet_Pin:string,
    public transaction : Transacion_Details
  ){}
}

export class Transacion_Details{
constructor(
  public t_id : string,
  public t_ammount:string,
  public caption:string,
  public t_date :string,
 
){}

}



@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
     private httpClient:HttpClient
  ) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      
    })
    
  }

public doSignUp(wallet1):Observable<Wallet>{

  console.log(wallet1); //2nd

  return this.httpClient.post<Wallet>(`http://localhost:9090/createNewUser`,JSON.stringify(wallet1), this.httpOptions); //wallet1,{responseType:'text' as 'json'});  //
}

public addbal(user,amount):Observable<any>{


  return this.httpClient.put<any>("http://localhost:9090/addBalanceToWallet/"+user+"/"+amount,this.httpOptions, {responseType:'text' as 'json'});
}

public depositbal(user,amount):Observable<any>{

  return this.httpClient.put<any>("http://localhost:9090/BankDeposit/"+user+"/"+amount,this.httpOptions,{responseType:'text' as 'json'});

}

public trasfer(user, receiver, amount, caption):Observable<any>{

  return this.httpClient.put<any>("http://localhost:9090/fundTransfer/"+user+"/"+receiver+"/"+amount+"/"+caption,this.httpOptions,{responseType:'text' as 'json'});
  
}

public getTransactionList(user):Observable<any>{

  return this.httpClient.get("http://localhost:9090/getTransaction/"+user);
}
 

}


