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
    private Long paymentId;
    private String service;
    private String typeservice;
    private float amount;
    private String paymentStatus;
}
