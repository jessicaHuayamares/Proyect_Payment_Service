package com.servicepayment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private String customerId;
    private String name;
    private String lastname;
    private String phone;
}
