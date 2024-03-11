package com.SBExtra.BankManagement.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SBExtra.BankManagement.DTO.Account;
import com.SBExtra.BankManagement.DTO.Branch;
import com.SBExtra.BankManagement.REPOSITORY.AccountRepository;

@Repository
public class AccountDAO 
{
	@Autowired
	AccountRepository repo;
	
	@Autowired 
	BranchDAO dao;
	
	public Account createAccount(int id, Account acc)
	{
		Branch b=dao.getById(id);
		List<Account> list=new ArrayList<Account>();
		list.add(acc);
		if(b!=null)
		{
			b.setAccount(list);
			acc.setBranch(b);
			return repo.save(acc);
		}
		return null;
	}
	
	public Account getAccById(int id)
	{
		Optional<Account> opt=repo.findById(id);
		if(opt!=null)
		{
			return opt.get();
		}return null;
	}
	
	public String deleteAccById(int id)
	{
		Account a=getAccById(id);
		if(a!=null)
		{
			repo.deleteById(id);
			return "Account deleted successfully...";
		}return"invalid id...";
	}
	
	public Account updateAccNmae(int id,String name)
	{
		Account a=getAccById(id);
		if(a!=null)
		{
			a.setAccholder_name(name);
			return repo.save(a);
		}return null;
	}
	
}
