package com.servicepayment.dto;

import com.servicepayment.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDTO implements Serializable {
    private Long transactionId;
    private Customer customer;
    private String accountNumber;
    private int serviceId;
    private float amount;
    private Date transactionDate;
}
