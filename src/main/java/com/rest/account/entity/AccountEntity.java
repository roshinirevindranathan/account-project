package com.rest.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account")
@EqualsAndHashCode(exclude = {"id"})
@NoArgsConstructor
public class AccountEntity {

  @Id
  @Column(nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false, length = 100)
  private String firstName;

  @Column(nullable = false, length = 100)
  private String secondName;

  @Column(nullable = false, length = 36)
  private String accountNumber;
}
