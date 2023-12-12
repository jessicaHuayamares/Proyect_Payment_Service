package com.servicepayment.customer.mapper;

import com.servicepayment.customer.dto.CustomerDTO;
import com.servicepayment.customer.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerDTO customerDTO);
    CustomerDTO toDTO(Customer customer);
}
