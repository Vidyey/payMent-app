package com.EazyPay.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "school")
public class demoSchool {
	@Id
	private int id;
	
	private String  sname;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "demoSchool [id=" + id + ", sname=" + sname + "]";
	}

	public demoSchool(int id, String sname) {
		super();
		this.id = id;
		this.sname = sname;
	}
	
	

}


