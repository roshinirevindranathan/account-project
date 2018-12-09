package com.rest.account.service;

import com.rest.account.model.AccountDto;
import com.rest.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<AccountDto> getAccounts(){
        return null;
    }

}
