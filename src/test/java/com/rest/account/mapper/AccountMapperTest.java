package com.rest.account.mapper;

import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

    @Test
    public void toAccountDtoTest(){

        final AccountEntity accountEntity = getAccountEntity();
        final AccountDto actual = AccountMapper.INSTANCE.toAccountDto(accountEntity);
        final AccountDto expected = getAccountDto();
        assertThat(actual).isEqualTo(expected);
    }

    private AccountEntity getAccountEntity() {
        final AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        accountEntity.setFirstName("John");
        accountEntity.setSecondName("Doe");
        accountEntity.setAccountNumber("1234");
        return accountEntity;
    }

    private AccountDto getAccountDto() {
        final AccountDto accountDto = new AccountDto();
        accountDto.setId(1L);
        accountDto.setFirstName("John");
        accountDto.setSecondName("Doe");
        accountDto.setAccountNumber("1234");
        return accountDto;
    }
}
