package com.EazyPay.demo.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EazyPay.demo.Exception.UserNotFoundException;
import com.EazyPay.demo.Logger.GlobalLogger;
import com.EazyPay.demo.Service.EazyPayServiceImpl;
import com.EazyPay.demo.entity.Transaction_Details;

import com.EazyPay.demo.entity.Wallet;
import com.EazyPay.demo.repo.TransactionRepositoty;

import com.EazyPay.demo.repo.WalletRepositoty;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WalletController {
	
	private Logger logger=GlobalLogger.getLogger(WalletController.class);
	
	@Autowired
	EazyPayServiceImpl wpsi;

@CrossOrigin
@PostMapping(path="/createNewUser",consumes ="application/json")
public Wallet addUser(@RequestBody Wallet newuser)
{
	String method="addUser(Wallet newuser)";
	logger.info(method + "called.."); 
	
	return wpsi.addUser(newuser);
	
}

@GetMapping("/getUser/{Mobile_Number}")
public Wallet getUser(@PathVariable String Mobile_Number) throws UserNotFoundException
{
	String method="getUser(String Mobile_Number)";
	logger.info(method + "called.."); 	
	
		Wallet w1 =  wpsi.getUser(Mobile_Number);
		
		if (w1==null)
		{
			throw new UserNotFoundException("user not found");
		}
		
		return w1;
}
 


@PutMapping("/updateUser")
public Wallet updateUser(@RequestBody Wallet newuser)
{
	String method="updateUser(Wallet newuser)";
	logger.info(method + "called.."); 
	
	return wpsi.updateUser(newuser);
	
}

@PutMapping("/fundTransfer/{send_upi_id}/{rec_upi_id}/{ammount}/{caption}")
public String transferFund (@PathVariable("send_upi_id") String send_upi_id,@PathVariable("rec_upi_id") String rec_upi_id, @PathVariable int ammount, @PathVariable String caption) 
{
	String method="transferFund(String send_upi_id,String rec_upi_id,int ammount, String caption)";
	logger.info(method + "called.."); 
	
	return wpsi.transferFund(send_upi_id, rec_upi_id, ammount, caption);
	
	
}


@PutMapping("/addBalanceToWallet/{Mobile_Number}/{ammount}")

public String addBalanceToWallet(@PathVariable("Mobile_Number") String upi_id, @PathVariable int ammount)
{
	String method="addBalanceToWallet(String upi_id,int ammount)";
	logger.info(method + "called.."); 	
	
	return wpsi.addBalanceToWallet(upi_id, ammount);
	
	
	
}

@GetMapping("/getTransaction/{Mobile_Number}")
public List<Transaction_Details> getTransaction(@PathVariable("Mobile_Number") String upi_id)
{
	String method="getTransaction(String upi_id)";
	logger.info(method + "called.."); 	
			 
	return wpsi.getTransaction(upi_id); 
	
}


@PutMapping("/BankDeposit/{upi_id}/{ammount}")
public String addBalanceToBank(@PathVariable String upi_id, @PathVariable int ammount )
{
	String method="addBalanceToBank(String upi_id,int ammount)";
	logger.info(method + "called.."); 	
	
	return wpsi.addBalanceToBank(upi_id, ammount);
	
	
}


}

