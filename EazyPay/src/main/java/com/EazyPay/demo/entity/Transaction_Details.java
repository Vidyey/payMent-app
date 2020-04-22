package com.EazyPay.demo.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	
	@Transient
	@GeneratedValue
	private int id_count;
		
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="Transaction_of_wallet")
	private Wallet wallet;
	
	
	

	public Transaction_Details(String t_id, int t_ammount, String caption, Date t_date, int id_count, Wallet wallet) {
		super();
		T_id = t_id;
		T_ammount = t_ammount;
		Caption = caption;
		T_date = t_date;
		this.id_count = id_count;
		this.wallet = wallet;
	}

	public Transaction_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction_Details(String t_id, int t_ammount, String caption, Date t_date, int id_count) {
		super();
		T_id = t_id;
		T_ammount = t_ammount;
		Caption = caption;
		T_date = t_date;
		this.id_count = id_count;
	}

	@Override
	public String toString() {
		return "Transaction [T_id=" + T_id + ", T_ammount=" + T_ammount + ", Caption=" + Caption + ", T_date=" + T_date
				+ ", id_count=" + id_count + "]";
	}

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

	public int getId_count() {
		return id_count;
	}

	public void setId_count(int id_count) {
		this.id_count = id_count;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}
