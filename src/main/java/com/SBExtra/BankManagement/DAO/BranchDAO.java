package com.SBExtra.BankManagement.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SBExtra.BankManagement.DTO.Bank;
import com.SBExtra.BankManagement.DTO.Branch;
import com.SBExtra.BankManagement.REPOSITORY.BranchRepository;

@Repository
public class BranchDAO 
{
	@Autowired
	BranchRepository repo;
	
	@Autowired
	BankDAO dao;
	
	public Branch CreateBank(int bank_id,Branch branch)//1
	{
		//getting the bank object using bANK ID
		Bank b=dao.getBankDetails(bank_id);
		//creating list to store all branches
		List<Branch> branches=new ArrayList<Branch>();
		//adding branch to the list
		branches.add(branch);
		//check if bank exist
		if(b!=null)
		{
			//only if bank exist
			//set branch list to bank
			b.setBranch(branches);
			//and set bank to branch
			branch.setBank(b);
			//store the branch details to DB
			return repo.save(branch);
		}
			return null;
		
	}
	
	public Branch getById(int id)//2
	{
		Optional<Branch> b=repo.findById(id);
		if(b!=null)
		{
			return b.get();
		}
		return null;
	}
	
	public List<Branch> getAllBranch()//3
	{
		return repo.findAll();
	}
	
	public String deleteById(int id)//4
	{
		Branch br=getById(id);
		if(br!=null)
		{
			repo.deleteById(id);;
			
			return "Deleted the  branch data sucessfully...";
		}
		return "Invalid id...";
	}
	
	public Branch updateBranchName(int id, String name)//5
	{
		Branch br=getById(id);
		if(br!=null)
		{
			br.setBranch_name(name);
			return repo.save(br);	
		}
		return null;
	}
}
