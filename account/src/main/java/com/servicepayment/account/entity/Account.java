package com.servicepayment.account.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Entity
@Table(name="tbl_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull
    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Double balance;

    public Account() {

    }
}
