package com.SBExtra.BankManagement.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.SBExtra.BankManagement.DAO.CustomerDAO;
import com.SBExtra.BankManagement.DTO.Account;
import com.SBExtra.BankManagement.DTO.Customer;

public class CustomerController 
{
	@Autowired
	CustomerDAO dao;
	
	@PostMapping("/add3")
	public Customer addvalue(@RequestParam int id , @RequestBody Customer customer)
	{
		return dao.createCustomer(id , customer);
	}
	
	@GetMapping("/add3")
	public Customer getacId(int id)
	{
		return dao.getCustomerById(id);
	}
	
	@DeleteMapping("/add3")
	public String deletebyid(int id)
	{
		return dao.deleteCustomerById(id);
	}
	
	@PutMapping("/add3")
	public Customer updatename(int id , String name)
	{
		return dao.updateCustomerNmae(id, name);
	}
}
