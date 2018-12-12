package com.rest.account.mapper;

import static com.rest.account.helper.TestHelper.getAccountDto;
import static com.rest.account.helper.TestHelper.getAccountEntity;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;
import java.util.List;
import org.junit.Test;

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

  @Test
  public void toAccountDtoEntityTest() {

    final AccountDto accountDto = getAccountDto();
    final AccountEntity actual = AccountMapper.INSTANCE.toAccountEntity(accountDto);
    final AccountEntity expected = getAccountEntity();
    assertThat(actual).isEqualTo(expected);
  }
}
