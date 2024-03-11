package com.SBExtra.BankManagement.DTO;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Branch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branch_id;
	private String branch_name;
	private String branch_location;
	
	@ManyToOne
	@JoinColumn
	Bank bank;
	
	@OneToMany(mappedBy = "branch" , cascade = CascadeType.REMOVE)//as in real time all these classes r related so any changes in other class will also be updated to another class
	List<Account> account;

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_location() {
		return branch_location;
	}

	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
}
