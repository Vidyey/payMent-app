package com.EazyPay.demo.entity;

import java.util.Date;

import javax.persistence.*;




@Entity
public class Transaction_Details {
	
	@Id
	private String T_id;
	@Column(length = 10)
	private int T_ammount;
	@Column(length = 30)
	private String Caption;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 20)
	private java.util.Date T_date;	

	/*
	 * @ManyToOne (cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="Transaction_of_wallet") private Wallet wallet;
	 */
	public String getT_id() {
		return T_id;
	}
	public void setT_id(String t_id) {
		T_id = t_id;
	}
	public int getT_ammount() {
		return T_ammount;
	}
	public void setT_ammount(int t_ammount) {
		T_ammount = t_ammount;
	}
	public String getCaption() {
		return Caption;
	}
	public void setCaption(String caption) {
		Caption = caption;
	}
	public java.util.Date getT_date() {
		return T_date;
	}
	public void setT_date(java.util.Date t_date) {
		T_date = t_date;
	}

	/*
	 * public Wallet getWallet() { return wallet; } public void setWallet(Wallet
	 * wallet) { this.wallet = wallet; }
	 */
	@Override
	public String toString() {
		return "Transaction_Details [T_id=" + T_id + ", T_ammount=" + T_ammount + ", Caption=" + Caption + ", T_date="
				+ T_date +  "]";
	}
	public Transaction_Details(String t_id, int t_ammount, String caption, Date t_date) {
		super();
		T_id = t_id;
		T_ammount = t_ammount;
		Caption = caption;
		T_date = t_date;
		//this.wallet = wallet;
	}
	public Transaction_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
