package com.SBExtra.BankManagement.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SBExtra.BankManagement.DTO.Account;
import com.SBExtra.BankManagement.DTO.Branch;
import com.SBExtra.BankManagement.DTO.Customer;
import com.SBExtra.BankManagement.REPOSITORY.CustomerRepository;

@Repository
public class CustomerDAO 
{
	@Autowired
	AccountDAO dao;
	
	@Autowired
	CustomerRepository repo;
	
	public Customer createCustomer(int Acc_id, Customer cus )
	{
		Account ac=dao.getAccById(Acc_id);
		List<Customer> list=new ArrayList<Customer>();
		list.add(cus);
		if(ac!=null)
		{
			ac.setCustomer(cus);
			cus.setAccount(ac);
			return repo.save(cus);
		}
		return null;
	}
	
	public Customer getCustomerById(int id)
	{
		Optional<Customer> opt=repo.findById(id);
		if(opt!=null)
		{
			return opt.get();
		}return null;
	}
	
	public String deleteCustomerById(int id)
	{
		Customer c=getCustomerById(id);
		if(c!=null)
		{
			repo.deleteById(id);
			return "Account deleted successfully...";
		}return"invalid id...";
	}
	
	public Customer updateCustomerNmae(int id,String name)
	{
		Customer c=getCustomerById(id);
		if(c!=null)
		{
			c.setCus_name(name);
			return repo.save(c);
		}return null;
	}
}
