package com.servicepayment.service;

import com.servicepayment.entity.Payment;
import com.servicepayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getpayments(){
        return paymentRepository.findAll();
    }

    //buscar typo de servicio a traves del id
    public Optional<Payment> getpayments(Long id){
        return paymentRepository.findById(id);
    }

    //guardar y actualizar

    public void saveOrUpdate(Payment payment){
        paymentRepository.save(payment);
    }
    //borrar
    public void delete(Long id){
        paymentRepository.deleteById(id);
    }
}
