package com.servicepayment.customer.service;

import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.entity.Payment;
import com.servicepayment.customer.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> listAllPayments() {
        return paymentRepository.findAll();
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

}
