package com.rest.account.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountDto {

    private Long id;
    private String firstName;
    private String secondName;
    private String accountNumber;
}
