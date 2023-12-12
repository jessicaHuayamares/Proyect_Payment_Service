package com.servicepayment.customer.dto;

import com.servicepayment.customer.entity.Financial_Information;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
public class CustomerDTO {
    private Long customerId;
    private String name;
    private String lastname;
    private String dni;
    private Financial_Information financialInformation;
}
