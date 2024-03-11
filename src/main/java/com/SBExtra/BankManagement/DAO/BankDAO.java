package com.SBExtra.BankManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SBExtra.BankManagement.DTO.Bank;
import com.SBExtra.BankManagement.REPOSITORY.BankRepository;

@Repository
public class BankDAO 
{
	@Autowired
	BankRepository repo;
	
	public Bank CreateBank(Bank bank)
	{
		return repo.save(bank);
	}
	
	public Bank getBankDetails(int id)
	{
		Optional<Bank> b=repo.findById(id);
		if(b.isPresent())
		{
			return b.get();
		}else
		return null;
	}

	public List<Bank> getAllBankDetails()
	{
		return repo.findAll();
	}
	
	public String updateBankName(int id)
	{
		Bank b=getBankDetails(id);
		if(b!=null)
		{
			b.setBank_name("IDFC");
			repo.save(b);
			return "Updaten name sucessfully...";
		}return "Invalid id..";
	}
	
	public String deleteBank(int id)
	{
		Bank b=getBankDetails(id);
		if(b!=null)
		{
			repo.delete(b);
			return "deleted bank succesfully...";
		}return "invalid id...";
	}
}
