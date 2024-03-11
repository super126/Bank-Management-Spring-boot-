package com.SBExtra.BankManagement.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBExtra.BankManagement.DAO.AccountDAO;
import com.SBExtra.BankManagement.DTO.Account;


@RestController
public class AccountCONTROLLER 
{
	
	@Autowired
	AccountDAO dao;
	
	@PostMapping("/add1")
	public Account addAccount(@RequestParam int id , @RequestBody Account account)
	{
		return dao.createAccount(id , account);
	}
	
	@GetMapping("/add1")
	public Account getacId(int id)
	{
		return dao.getAccById(id);
	}
	
	@DeleteMapping("/add1")
	public String deletebyid(int id)
	{
		return dao.deleteAccById(id);
	}
	
	@PutMapping("/add1")
	public Account updatename(int id , String name)
	{
		return dao.updateAccNmae(id, name);
	}
}
