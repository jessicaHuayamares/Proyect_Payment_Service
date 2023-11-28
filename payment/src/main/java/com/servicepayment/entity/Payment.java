package com.servicepayment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="tbl_payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Long customerId;
    private Long serviceId;
    private Long typeServiceId;
    private float amount;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    private String Date;


}
