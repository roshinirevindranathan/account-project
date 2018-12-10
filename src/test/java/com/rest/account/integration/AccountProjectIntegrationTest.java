package com.rest.account.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.rest.account.AccountApplication;
import com.rest.account.entity.AccountEntity;
import com.rest.account.model.AccountDto;
import com.rest.account.model.MessageDto;
import com.rest.account.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {AccountApplication.class})
public class AccountProjectIntegrationTest {

  private static final String LOCALHOST = "http://localhost:";
  private static final String BASE_URI = "/account-project/rest/account/json";
  private static final String ACCOUNT_ADDED = "account has been successfully added";
  private static final String ACCOUNT_SUCCESSFULLY_DELETED = "account successfully deleted";

  private TestRestTemplate restTemplate = new TestRestTemplate();

  @LocalServerPort
  private int randomServerPort;

  @Autowired
  private AccountRepository repository;

  @Before
  public void setUp() {
    repository.deleteAllInBatch();
  }

  @Test
  public void getAccountsTest() {

    final AccountEntity expected = insertAccountDataToDB();

    final String getAccountsUrl = LOCALHOST + randomServerPort + BASE_URI;
    final ResponseEntity<AccountDto[]> response = restTemplate
        .getForEntity(getAccountsUrl, AccountDto[].class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    final AccountDto[] actual = response.getBody();
    validateResponse(actual[0], expected);
  }

  @Test
  public void postAccountTest() {

    final AccountDto accountDto = getAccountDto();
    final String postAccountUrl = LOCALHOST + randomServerPort + BASE_URI;
    final ResponseEntity<MessageDto> response = restTemplate
        .postForEntity(postAccountUrl, accountDto, MessageDto.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody().getMessage()).isEqualTo(ACCOUNT_ADDED);
  }

  @Test
  public void deleteAccountTest() {

    final AccountEntity existingAccount = insertAccountDataToDB();
    final String deleteAccountUrl =
        LOCALHOST + randomServerPort + BASE_URI + "/" + existingAccount.getId();

    final ResponseEntity<MessageDto> response = restTemplate
        .exchange(deleteAccountUrl, HttpMethod.DELETE,null, MessageDto.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().getMessage()).isEqualTo(ACCOUNT_SUCCESSFULLY_DELETED);
  }

  private void validateResponse(final AccountDto actual, final AccountEntity expected) {

    assertThat(actual.getId()).isEqualTo(expected.getId());
    assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
    assertThat(actual.getSecondName()).isEqualTo(expected.getSecondName());
    assertThat(actual.getAccountNumber()).isEqualTo(expected.getAccountNumber());
  }


  private AccountEntity insertAccountDataToDB() {

    AccountEntity accountEntity = getAccountEntity();
    return repository.save(accountEntity);
  }

  private AccountDto getAccountDto() {

    return AccountDto.builder()
        .id(1L)
        .firstName("John")
        .secondName("Doe")
        .accountNumber("1234")
        .build();
  }

  private AccountEntity getAccountEntity() {
    return AccountEntity.builder()
        .id(1L)
        .firstName("John")
        .secondName("Doe")
        .accountNumber("1234")
        .build();
  }

}
