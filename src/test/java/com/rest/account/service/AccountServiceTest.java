package com.rest.account.service;

import com.rest.account.entity.AccountEntity;
import com.rest.account.mapper.AccountMapper;
import com.rest.account.model.AccountDto;
import com.rest.account.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

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
}