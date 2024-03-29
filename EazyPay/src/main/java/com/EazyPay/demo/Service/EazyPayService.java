package com.EazyPay.demo.Service;

import java.util.List;
import java.util.Optional;

import com.EazyPay.demo.Exception.UserNotFoundException;
import com.EazyPay.demo.entity.Transaction_Details;
import com.EazyPay.demo.entity.Wallet;

public interface EazyPayService {
	
	public Wallet addUser(Wallet newuser);
	public Wallet getUser(String Mobile_Number) throws UserNotFoundException ;
	public Wallet updateUser(Wallet newuser);
	public String transferFund (String send_upi_id,String rec_upi_id,int ammount, String caption);
	public String addBalanceToWallet(String upi_id,int ammount);
	public List<Transaction_Details> getTransaction(String upi_id);
	public String addBalanceToBank(String upi_id, int ammount );

}
