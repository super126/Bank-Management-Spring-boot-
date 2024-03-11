package com.SBExtra.BankManagement.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBExtra.BankManagement.DAO.BankDAO;
import com.SBExtra.BankManagement.DTO.Bank;

@RestController
public class BankController 
{
	@Autowired
	BankDAO dao;
	
	@PostMapping("/add")
	public Bank addBank(@RequestBody 	Bank bank)
	{
		return dao.CreateBank(bank);
	}
	
	@GetMapping("/add")
	public Bank getById(@RequestParam int id)
	{
		return dao.getBankDetails(id);
	}
	
	@GetMapping("/find")
	public List<Bank> findAllData()
	{
		return dao.getAllBankDetails();
	}
	
	@PutMapping("/add")
	public String updateName(@RequestParam int bank_id)
	{
		return dao.updateBankName(bank_id);
	}
	
	@DeleteMapping("/add")
	public String deletebk(@RequestParam int id)
	{
		return dao.deleteBank(id);
	}
}
