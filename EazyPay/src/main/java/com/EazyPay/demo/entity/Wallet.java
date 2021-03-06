package com.EazyPay.demo.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Wallet {
	@Id
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length = 30, unique = true, nullable = false)
	private String Mobile_Number;
	@Column(length = 30, unique = true, nullable = false)
	private String Email_id;
	
	@Column(length = 12, unique = true, nullable = false)
	private String Adhar_Number;
	@Column(length = 30)
	private String Name; 
	@Column(length = 12)
	private float Wallet_Ammount;
	@Column(length = 8)
	private String Wallet_Pin;
	

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(targetEntity = Transaction_Details.class)
	private List<Transaction_Details> transaction;
	public String getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(String mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getAdhar_Number() {
		return Adhar_Number;
	}
	public void setAdhar_Number(String adhar_Number) {
		Adhar_Number = adhar_Number;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
		return "Wallet [Mobile_Number=" + Mobile_Number + ", Email_id=" + Email_id + ", Adhar_Number=" + Adhar_Number
				+ ", Name=" + Name + ", Wallet_Ammount=" + Wallet_Ammount + ", Wallet_Pin=" + Wallet_Pin
				+ ", transaction=" + transaction + "]";
	}
	public Wallet(String mobile_Number, String email_id, String adhar_Number, String name, float wallet_Ammount,
			String wallet_Pin, List<Transaction_Details> transaction) {
		super();
		Mobile_Number = mobile_Number;
		Email_id = email_id;
		Adhar_Number = adhar_Number;
		Name = name;
		Wallet_Ammount = wallet_Ammount;
		Wallet_Pin = wallet_Pin;
		this.transaction = transaction;
	}
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
