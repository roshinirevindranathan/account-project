package com.rest.account.controller;

import com.rest.account.model.AccountDto;
import com.rest.account.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

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
}