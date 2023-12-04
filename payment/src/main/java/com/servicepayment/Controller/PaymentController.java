package com.servicepayment.Controller;

import com.servicepayment.entity.Payment;
import com.servicepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping
    public ResponseEntity<List<Payment>> listPayments() {
        List<Payment> payments = paymentService.listAllPayments();
        if (payments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(payments);
    }

    @PostMapping("api/v5/createPayment")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.makePayment(payment);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }
}
