package com.rest.account.service;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rest.account.entity.AccountEntity;
import com.rest.account.mapper.AccountMapper;
import com.rest.account.model.AccountDto;
import com.rest.account.model.MessageDto;
import com.rest.account.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

  private static final String ACCOUNT_ADDED = "account has been successfully added";
  private static final String ACCOUNT_SUCCESSFULLY_DELETED = "account successfully deleted";

  @Mock
  private AccountRepository accountRepository;

  @Mock
  private AccountMapper accountMapper;

  private AccountService accountService;

  @Before
  public void setUp() {
    accountService = new AccountService(accountRepository, accountMapper);
  }

  @Test
  public void getAccounts() {

    final List<AccountEntity> accountEntities = new ArrayList<>();
    when(accountRepository.findAll()).thenReturn(accountEntities);

    final List<AccountDto> expected = mock(List.class);
    when(accountMapper.toAccountDtoList(accountEntities)).thenReturn(expected);

    final List<AccountDto> actual = accountService.getAccounts();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void saveAccountTest() {

    final AccountDto accountDto = mock(AccountDto.class);
    final AccountEntity accountEntity = mock(AccountEntity.class);

    when(accountMapper.toAccountEntity(accountDto)).thenReturn(accountEntity);
    final MessageDto actual = accountService.saveAccount(accountDto);

    assertThat(actual).isEqualTo(new MessageDto(ACCOUNT_ADDED));
    verify(accountRepository).save(accountEntity);
  }

  @Test
  public void deleteAccountTest() {

    final Long id = 1L;

    final MessageDto actual = accountService.deleteAccount(id);
    final MessageDto expected = new MessageDto(ACCOUNT_SUCCESSFULLY_DELETED);

    assertThat(actual).isEqualTo(expected);
    verify(accountRepository).deleteById(id);
  }
}