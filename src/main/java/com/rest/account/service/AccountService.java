package com.rest.account.service;

import com.rest.account.mapper.AccountMapper;
import com.rest.account.model.AccountDto;
import com.rest.account.model.MessageDto;
import com.rest.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository,
                          AccountMapper accountMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccountDto> getAccounts(){
        return accountMapper.toAccountDtoList(accountRepository.findAll());
    }

    public MessageDto saveAccount(final AccountDto accountDto) {

        return null;
    }

}
