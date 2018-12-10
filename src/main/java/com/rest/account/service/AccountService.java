package com.rest.account.service;

import com.rest.account.mapper.AccountMapper;
import com.rest.account.model.AccountDto;
import com.rest.account.model.MessageDto;
import com.rest.account.repository.AccountRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private static final String ACCOUNT_ADDED = "account has been successfully added";
  private static final String ACCOUNT_SUCCESSFULLY_DELETED = "account successfully deleted";

  private AccountRepository accountRepository;
  private AccountMapper accountMapper;

  public AccountService(AccountRepository accountRepository,
      AccountMapper accountMapper) {

    this.accountRepository = accountRepository;
    this.accountMapper = accountMapper;
  }

  public List<AccountDto> getAccounts() {
    return accountMapper.toAccountDtoList(accountRepository.findAll());
  }

  public MessageDto saveAccount(final AccountDto accountDto) {
    accountRepository.save(accountMapper.toAccountEntity(accountDto));
    return new MessageDto(ACCOUNT_ADDED);
  }

  public MessageDto deleteAccount(final Long id) {
    accountRepository.deleteById(id);
    return new MessageDto(ACCOUNT_SUCCESSFULLY_DELETED);
  }
}
