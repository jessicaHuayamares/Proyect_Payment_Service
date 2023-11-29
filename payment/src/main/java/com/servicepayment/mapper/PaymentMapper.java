package com.servicepayment.mapper;
//import org.mapstruct.Mapper;
import com.servicepayment.dto.PaymentDTO;
import com.servicepayment.entity.Payment;
//@Mapper(componentModel = "spring")
public abstract class PaymentMapper {
    public abstract Payment toEntity(PaymentDTO paymentDTO);
    public abstract PaymentDTO toDTO(Payment payment);
}
