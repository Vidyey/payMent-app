package com.EazyPay.demo.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EazyPay.demo.Exception.UserNotFoundException;
import com.EazyPay.demo.Logger.GlobalLogger;
import com.EazyPay.demo.entity.Transaction_Details;
import com.EazyPay.demo.entity.Wallet;
import com.EazyPay.demo.repo.TransactionRepositoty;
import com.EazyPay.demo.repo.WalletRepositoty;

@Repository
public class EazyPayDaoImpl implements EazyPayDao {

private Logger logger=GlobalLogger.getLogger(EazyPayDaoImpl.class);
	
	@Autowired
	private WalletRepositoty walletRepositoty;
	@Autowired
	private TransactionRepositoty transactionRepositoty;

	public Wallet addUser(Wallet newuser) {
		
		String method="addUser(Wallet newuser)";
		logger.info(method + "called.."); 
		
		System.out.println(newuser); //
		newuser.setWallet_Ammount(0);
		return walletRepositoty.save(newuser);
	}

	public Wallet getUser(String Mobile_Number) throws UserNotFoundException {

		String method="getUser(String Mobile_Number)";
		logger.info(method + "called.."); 
		
		Wallet w1 =  walletRepositoty.findById(Mobile_Number).orElseThrow(()-> new UserNotFoundException("user not found"));
		
		return w1;
	}

	public Wallet updateUser(Wallet newuser) {
		
		String method="updateUser(Wallet newuser)";
		logger.info(method + "called..");
		
		return walletRepositoty.save(newuser);
	}
	
	public String transferFund(String send_upi_id, String rec_upi_id, int ammount, String caption) { 
		
		String method="transferFund(String send_upi_id,String rec_upi_id,int ammount, String caption)";
		logger.info(method + "called..");
		
     Wallet send = walletRepositoty.getOne(send_upi_id);
		
		System.out.println("this is sending onj :- "+send);
		Wallet rec = walletRepositoty.getOne(rec_upi_id);
		
		System.out.println("this is reciver :- "+ rec);
		
		if ( send.getWallet_Ammount() >= ammount) {
		
		String id = send_upi_id+"#"+Calendar.getInstance().getTime()+"#"+rec_upi_id;
		
		//---------------- debit process --------------
		Transaction_Details sendbal = new Transaction_Details(id,ammount, caption, Calendar.getInstance().getTime());
		send.setWallet_Ammount(send.getWallet_Ammount() - sendbal.getT_ammount());
		
		List<Transaction_Details> t = send.getTransaction();
		t.add(sendbal);
		send.setTransaction(t);
		
		transactionRepositoty.save(sendbal);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ----------------credit process-------------------------
		String id1 = send_upi_id+"#"+Calendar.getInstance().getTime()+"#"+rec_upi_id;
		Transaction_Details recbal = new Transaction_Details(id1,ammount, caption, Calendar.getInstance().getTime());
		
		rec.setWallet_Ammount(rec.getWallet_Ammount() + recbal.getT_ammount());
		
		
		
		List<Transaction_Details> t2 = rec.getTransaction();
		t2.add(recbal);
		rec.setTransaction(t2);
		
		
		transactionRepositoty.save(recbal);
		//----------------------------------------------------
		
		//wallet update
		
		walletRepositoty.save(send);
		walletRepositoty.save(rec);
	
		return "fund transfer successful";
		}
		else
		{
			return "transaction failed  'Unsufficient balance'. ";
		}
		
	}

	public String addBalanceToWallet(String upi_id, int ammount) {
		
		String method="addBalanceToWallet(String upi_id,int ammount)";
		logger.info(method + "called..");
		
      Wallet w1 = walletRepositoty.getOne(upi_id);
		
		String id = upi_id+"#"+Calendar.getInstance().getTime()+"#balanceAdded";
		
		Transaction_Details addbal = new Transaction_Details(id,ammount, "wallet_balance_added", Calendar.getInstance().getTime());
		
		w1.setWallet_Ammount(w1.getWallet_Ammount() + addbal.getT_ammount());
		List<Transaction_Details> t = w1.getTransaction();
		t.add(addbal);
		w1.setTransaction(t);
		
		transactionRepositoty.save(addbal);
		walletRepositoty.save(w1);
		
		return "Balance added to Wallet successful...";
	}

	public List<Transaction_Details> getTransaction(String upi_id) {
		
		String method="getTransaction(String upi_id)";
		logger.info(method + "called.."); 
		
		Wallet w1 = walletRepositoty.getOne(upi_id);
		return w1.getTransaction();
	}

	public String addBalanceToBank(String upi_id, int ammount) {
		
		String method="addBalanceToBank(String upi_id,int ammount)";
		logger.info(method + "called.."); 	
		
       Wallet w1 = walletRepositoty.getOne(upi_id);
		
		if (w1.getWallet_Ammount()>=ammount)
		{

		String id = upi_id+"#"+Calendar.getInstance().getTime()+"#bankDeposited";

		Transaction_Details addbal = new Transaction_Details(id,ammount, "wallet_balance_Deposited", Calendar.getInstance().getTime());

		w1.setWallet_Ammount(w1.getWallet_Ammount() - addbal.getT_ammount());
		List<Transaction_Details> t = w1.getTransaction();
		t.add(addbal);
		w1.setTransaction(t);
		transactionRepositoty.save(addbal);
		walletRepositoty.save(w1);
		return "Balance added to Bank successful...";
		}   
		else
		{
			return "Unsufficient balance...";
		}
	}

	

}
