package com.rest.account.helper;

import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;

public class TestHelper {

  private static final String FIRST_NAME = "John";
  private static final String SECOND_NAME = "Doe";
  private static final String ACCOUNT_NUMBER = "1234";
  private static final long ID = 1L;

  public static AccountDto getAccountDto() {
    return AccountDto.builder()
        .id(ID)
        .firstName(FIRST_NAME)
        .secondName(SECOND_NAME)
        .accountNumber(ACCOUNT_NUMBER)
        .build();
  }

  public static AccountEntity getAccountEntity() {
    return AccountEntity.builder()
        .id(ID)
        .firstName(FIRST_NAME)
        .secondName(SECOND_NAME)
        .accountNumber(ACCOUNT_NUMBER)
        .build();
  }
}
