package com.servicepayment.account.service;

import com.servicepayment.account.entity.Account;
import com.servicepayment.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getaccounts(){
        return accountRepository.findAll();
    }

    //buscar typo de servicio a traves del id
    public Optional<Account> getaccounts(Long id){
        return accountRepository.findById(id);
    }

    //guardar y actualizar

    public void saveOrUpdate(Account account){
        accountRepository.save(account);
    }
    //borrar
    public void delete(Long id){
        accountRepository.deleteById(id);
    }
}
