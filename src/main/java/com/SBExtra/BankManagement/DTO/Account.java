package com.SBExtra.BankManagement.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acc_id;
	private long acc_no;
	private String accholder_name;
	private double acc_balance;
	private String acc_IFSC;
	
	@ManyToOne
	@JoinColumn
	Branch branch;
	
	@OneToOne(mappedBy = "account" , cascade = CascadeType.ALL)
	Customer customer;

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAccholder_name() {
		return accholder_name;
	}

	public void setAccholder_name(String accholder_name) {
		this.accholder_name = accholder_name;
	}

	public double getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}

	public String getAcc_IFSC() {
		return acc_IFSC;
	}

	public void setAcc_IFSC(String acc_IFSC) {
		this.acc_IFSC = acc_IFSC;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
