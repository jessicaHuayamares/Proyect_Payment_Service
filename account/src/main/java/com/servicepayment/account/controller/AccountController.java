package com.servicepayment.account.controller;

import com.servicepayment.account.entity.Account;
import com.servicepayment.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getaccounts();

    }

    @GetMapping("/{accountId}")
    public Optional<Account> getBId(@PathVariable("accountId") Long accountId){
        return accountService.getaccounts(accountId);

    }

    @PostMapping
    public void saveUpdate(@RequestBody Account account) {
        accountService.saveOrUpdate(account);
    }

    @DeleteMapping("/{accountId}")
    public void saveUpdate(@PathVariable("accountId") Long typeserviceId) {
        accountService.delete(typeserviceId);
    }
}
