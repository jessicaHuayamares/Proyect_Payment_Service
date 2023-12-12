package com.servicepayment.customer.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PaymentDTO implements Serializable {
    private Long paymentId;
    private String service;
    private String typeservice;
    private float amount;
    private String accountNumber;
}