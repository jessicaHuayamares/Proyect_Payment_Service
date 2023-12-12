package com.servicepayment.customer.mapper;

import com.servicepayment.customer.dto.PaymentDTO;
import com.servicepayment.customer.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentDTO paymentDTO);
    PaymentDTO toDTO(Payment payment);
    List<PaymentDTO> toDtoList(List<Payment> payments);
}
