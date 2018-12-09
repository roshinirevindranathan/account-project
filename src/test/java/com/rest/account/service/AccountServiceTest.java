package com.rest.account.service;

import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;
import com.rest.account.repository.AccountRepository;
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
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void getAccounts() {

        final List<AccountEntity> expected = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(expected);
        final List<AccountDto> actual = accountService.getAccounts();
        assertThat(actual).isEqualTo(expected);
    }
}