package com.servicepayment.service;

import com.servicepayment.entity.Payment;
import com.servicepayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> listAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            paymentRepository.delete(payment);
        }
        return payment;
    }

    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
