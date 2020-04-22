package com.EazyPay.demo.entity;

import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table (name = "User_Details")
public class User_Details {

		@Id
		@GeneratedValue
		
		private int Cust_ID;
		
		@Column(length = 10, unique = true, nullable = false)
		private BigInteger Mobile_Number;
		@Column(length = 30, unique = true, nullable = false)
		private String Email_id;
		
		@Column(length = 12, unique = true, nullable = false)
		private BigInteger Adhar_Number;
		@Column(length = 30)
		private String Name; 
		@Column(length = 30)
		private String Bank_Name;
		@Column(length = 30)
		private int Account_Details;
		@Column(length = 20)
		private String Password;
		
		@OneToOne
		private Wallet  wallet;
		
		
		public Wallet getWallet() {
			return wallet;
		}
		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}
		public int getCust_ID() {
			return Cust_ID;
		}
		public void setCust_ID(int cust_ID) {
			Cust_ID = cust_ID;
		}
		public BigInteger getMobile_Number() {
			return Mobile_Number;
		}
		public void setMobile_Number(BigInteger mobile_Number) {
			Mobile_Number = mobile_Number;
		}
		public String getEmail_id() {
			return Email_id;
		}
		public void setEmail_id(String email_id) {
			Email_id = email_id;
		}
		public BigInteger getAdhar_Number() {
			return Adhar_Number;
		}
		public void setAdhar_Number(BigInteger adhar_Number) {
			Adhar_Number = adhar_Number;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getBank_Name() {
			return Bank_Name;
		}
		public void setBank_Name(String bank_Name) {
			Bank_Name = bank_Name;
		}
		public int getAccount_Details() {
			return Account_Details;
		}
		public void setAccount_Details(int account_Details) {
			Account_Details = account_Details;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public User_Details(int cust_ID, BigInteger mobile_Number, String email_id, BigInteger adhar_Number, String name,
				String bank_Name, int account_Details, String password, Wallet wallet) {
			super();
			Cust_ID = cust_ID;
			Mobile_Number = mobile_Number;
			Email_id = email_id; 
			Adhar_Number = adhar_Number;
			Name = name;
			Bank_Name = bank_Name;
			Account_Details = account_Details;
			Password = password;
			this.wallet = wallet;
		}
		public User_Details() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "User_Details [Cust_ID=" + Cust_ID + ", Mobile_Number=" + Mobile_Number + ", Email_id=" + Email_id
					+ ", Adhar_Number=" + Adhar_Number + ", Name=" + Name + ", Bank_Name=" + Bank_Name
					+ ", Account_Details=" + Account_Details + ", Password=" + Password + ", wallet=" + wallet + "]";
		}
	   
}
