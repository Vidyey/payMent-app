package com.EazyPay.demo.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Wallet {
	@Id

	private String Upi_ID;
	@Column(length = 12)
	private float Wallet_Ammount;
	@Column(length = 8)
	private String Wallet_Pin;
	
	@OneToMany(targetEntity = Transaction_Details.class, mappedBy="wallet")
	private List<Transaction_Details> transaction;
	
	
	public String getUpi_ID() {
		return Upi_ID;
	}
	public void setUpi_ID(String upi_ID) {
		Upi_ID = upi_ID;
	}
	public float getWallet_Ammount() {
		return Wallet_Ammount;
	}
	public void setWallet_Ammount(float wallet_Ammount) {
		Wallet_Ammount = wallet_Ammount;
	}
	public String getWallet_Pin() {
		return Wallet_Pin;
	}
	public void setWallet_Pin(String wallet_Pin) {
		Wallet_Pin = wallet_Pin;
	}
	public List<Transaction_Details> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction_Details> transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "Wallet [Upi_ID=" + Upi_ID + ", Wallet_Ammount=" + Wallet_Ammount + ", Wallet_Pin=" + Wallet_Pin + "]";
	}
	public Wallet(String upi_ID, float wallet_Ammount, String wallet_Pin) {
		super();
		Upi_ID = upi_ID;
		Wallet_Ammount = wallet_Ammount;
		Wallet_Pin = wallet_Pin;
	}
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
