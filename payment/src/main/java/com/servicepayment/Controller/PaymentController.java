package com.servicepayment.Controller;

import com.servicepayment.entity.Payment;
import com.servicepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v5/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll(){
        return paymentService.getpayments();

    }

    @GetMapping("/{paymentId}")
    public Optional<Payment> getBId(@PathVariable("paymentId") Long accountId){
        return paymentService.getpayments(accountId);

    }

    @PostMapping
    public void saveUpdate(@RequestBody Payment account) {
        paymentService.saveOrUpdate(account);
    }

    @DeleteMapping("/{accountId}")
    public void saveUpdate(@PathVariable("accountId") Long typeserviceId) {
        paymentService.delete(typeserviceId);
    }
}
