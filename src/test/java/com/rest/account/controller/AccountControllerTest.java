package com.rest.account.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.rest.account.model.AccountDto;
import com.rest.account.model.MessageDto;
import com.rest.account.service.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

  private static final String ACCOUNT_ADDED = "account has been successfully added";
  @Mock
  private AccountService accountService;
  private AccountController accountController;

  @Before
  public void setUp() {
    accountController = new AccountController(accountService);
  }

  @Test
  public void getAccounts_shouldReturnAccounts_whenCalled() {

    final List<AccountDto> expected = new ArrayList<>();
    when(accountService.getAccounts()).thenReturn(expected);
    final List<AccountDto> actual = accountController.getAccounts();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void postAccount_shouldCreateNewAccount() {

    final AccountDto account = mock(AccountDto.class);
    final MessageDto expected = new MessageDto(ACCOUNT_ADDED);
    when(accountService.saveAccount(account)).thenReturn(expected);

    final MessageDto actual = accountController.postAccount(account);
    assertThat(actual).isEqualTo(expected);
  }

}