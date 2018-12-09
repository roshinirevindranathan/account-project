package com.rest.account.mapper;

import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

    @Test
    public void toAccountDtoTest() {

        final AccountEntity accountEntity = getAccountEntity();
        final AccountDto actual = AccountMapper.INSTANCE.toAccountDto(accountEntity);
        final AccountDto expected = getAccountDto();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void toAccountDtoListTest() {

        final List<AccountEntity> accountEntities = singletonList(getAccountEntity());
        final List<AccountDto> actual = AccountMapper.INSTANCE.toAccountDtoList(accountEntities);
        final List<AccountDto> expected = singletonList(getAccountDto());
        assertThat(actual).isEqualTo(expected);
    }

    private AccountEntity getAccountEntity() {

        return AccountEntity.builder()
                .id(1L)
                .firstName("John")
                .secondName("Doe")
                .accountNumber("1234")
                .build();
    }

    private AccountDto getAccountDto() {

        return AccountDto.builder()
                .id(1L)
                .firstName("John")
                .secondName("Doe")
                .accountNumber("1234")
                .build();
    }
}
