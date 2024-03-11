package com.SBExtra.BankManagement.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBExtra.BankManagement.DTO.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>
{

}
