package com.servicepayment.customer.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private int customerId;
    private int accountId;
    private int serviceId;
    private float amount;
}