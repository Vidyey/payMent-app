import { Component, OnInit } from '@angular/core';
import { HttpClientService, Wallet } from '../service/http-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  wallet1 : Wallet = new Wallet("","","","","","",null);

  message : any;

  constructor(private router: Router,
    private service : HttpClientService) { }

  ngOnInit(): void {
  }


  public signupNow(){

    console.log(this.wallet1); // 1st

    this.service.doSignUp(this.wallet1).subscribe((data)=>this.wallet1=data);

    console.log("new value ", this.wallet1);
  }

}
