package com.servicepayment.customer.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDTO {
    private Long customerId;
    private String nombre;
    private String dni;
    private String accountNumber;
}
