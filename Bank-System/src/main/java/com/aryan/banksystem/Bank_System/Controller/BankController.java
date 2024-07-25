package com.aryan.banksystem.Bank_System.Controller;

import com.aryan.banksystem.Bank_System.BankService.BankService;
import com.aryan.banksystem.Bank_System.Model.Bank;
import com.aryan.banksystem.Bank_System.Model.BankDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Bank")
public class BankController {
    @Autowired
    private BankService bankService;

    //create account
    @PostMapping("open-account")
    public ResponseEntity<Bank> openAccount(@RequestBody BankDTO bankDTO){
        try{
            return new ResponseEntity<>(bankService.openAccount(bankDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }

    @PutMapping("withdraw-money/{acNo}/{amount}")
    public ResponseEntity<?>withdrawMoney(@PathVariable long acNo,@PathVariable double amount){
        return bankService.withdrawMoney(acNo,amount);
    }

    @PutMapping("deposit-money/{acNo}/{amount}")
    public ResponseEntity<?> depositMoney(@PathVariable long acNo,@PathVariable double amount){
        return bankService.depositMoney(acNo,amount);
    }

    @PutMapping("transfer-money/{senderAcNo}/{receiverAcNo}/{amount}")
    public ResponseEntity<?> transferMoney(@PathVariable long senderAcNo , @PathVariable long receiverAcNo,@PathVariable double amount){
        return bankService.transferMoney(senderAcNo,receiverAcNo,amount);
    }

    @GetMapping("check-balance/{acNo}")
    public ResponseEntity<?> getAccountBalance(@PathVariable long acNo){
        return bankService.getAccountBalance(acNo);
    }
}
