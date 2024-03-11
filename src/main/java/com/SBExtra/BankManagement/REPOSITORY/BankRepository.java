package com.SBExtra.BankManagement.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBExtra.BankManagement.DTO.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>
{

}
