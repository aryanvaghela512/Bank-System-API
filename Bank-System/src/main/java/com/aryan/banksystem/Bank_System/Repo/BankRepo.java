package com.aryan.banksystem.Bank_System.Repo;

import com.aryan.banksystem.Bank_System.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Integer> {
    Bank findByAcNo(long acBalance);
}
