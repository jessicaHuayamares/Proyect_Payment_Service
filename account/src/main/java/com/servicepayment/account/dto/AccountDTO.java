package com.servicepayment.account.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Long accountId;
    private String accountNumber;
    private Double balance;
}
