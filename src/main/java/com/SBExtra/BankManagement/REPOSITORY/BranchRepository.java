package com.SBExtra.BankManagement.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBExtra.BankManagement.DTO.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>
{

}
