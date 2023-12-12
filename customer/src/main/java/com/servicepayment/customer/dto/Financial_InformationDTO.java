package com.servicepayment.customer.dto;

import com.servicepayment.customer.entity.Customer;
import lombok.Data;

@Data
public class Financial_InformationDTO {
    private Long id;

    private String accountType;
    private String accountNumber;
    private float amount;
    private Customer customer;
}