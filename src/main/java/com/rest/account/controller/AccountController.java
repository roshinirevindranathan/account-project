package com.rest.account.controller;

import com.rest.account.model.AccountDto;
import com.rest.account.model.MessageDto;
import com.rest.account.service.AccountService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-project/rest/account/json")
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public List<AccountDto> getAccounts() {
    return accountService.getAccounts();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageDto postAccount(@RequestBody final AccountDto accountDto){
    return accountService.saveAccount(accountDto);
  }

  @DeleteMapping("/{id}")
  public MessageDto deleteAccount(@PathVariable("id") final Long id){
    return accountService.deleteAccount(id);
  }
}
