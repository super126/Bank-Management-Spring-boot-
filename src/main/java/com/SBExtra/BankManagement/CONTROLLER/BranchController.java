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

import com.SBExtra.BankManagement.DAO.BranchDAO;
import com.SBExtra.BankManagement.DTO.Branch;

@RestController
public class BranchController 
{
	@Autowired
	BranchDAO dao;
	
	@PostMapping("/add2")
	public Branch AddEleement(@RequestBody Branch branch , @RequestParam int bank_id)
	{
		return dao.CreateBank(bank_id, branch);
	}
	
	@GetMapping("/add2")
	public Branch GetBranchById(@RequestParam int id)
	{
		return dao.getById(id);
	}
	
	@GetMapping("/all2")
	public List<Branch> getAlBranch()
	{
		return dao.getAllBranch();
	}
	
	@DeleteMapping("/del2")
	public String deleteBranchId(@RequestParam int id)
	{
		return dao.deleteById(id);
	}
	
	@PutMapping("/upd2")
	public Branch updateName(@RequestParam int id,@RequestParam String name)
	{
		return dao.updateBranchName(id , name);
	}
}
