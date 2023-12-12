package com.servicepayment.customer.controller;
import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.entity.Payment;
import com.servicepayment.customer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v5/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RestTemplate restTemplate; // Autowire RestTemplate for making HTTP requests
    private final String CUSTOMER_SERVICE_URL = "http://localhost:8080/api/v4/customers/";

    @Autowired
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
    @PostMapping("/createPayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PostMapping("/createPayment2")
    public ResponseEntity<String> createPayment2(@RequestBody Payment payment) {
        try {
            String accountNumber = payment.getAccountNumber();
            String customerServiceUrl = CUSTOMER_SERVICE_URL + payment.getAccountNumber();
            System.out.println("La URL completa es: " + customerServiceUrl);

            ResponseEntity<Customer> response = restTemplate.getForEntity(customerServiceUrl, Customer.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                Customer customer = response.getBody();
                if (customer.getFinancialInformation().getAmount() >= payment.getAmount()) {
                    //System.out.println("gaaaaaaaaaaaaaaaaaaaaaaa."+payment);

                    paymentService.createPayment(payment);
                    //System.out.println("PAYMENT."+payment);
                    customer.getFinancialInformation().setAmount(customer.getFinancialInformation().getAmount() - payment.getAmount());
                    //System.out.println("NUEVO MONTO"+customer.getFinancialInformation().getAmount());
                    restTemplate.put(CUSTOMER_SERVICE_URL+"/update/"+customer.getFinancialInformation().getAccountNumber(), customer);
                    System.out.println("ENVIAR");
                    return ResponseEntity.ok("Payment successful!");
                } else {
                    return ResponseEntity.badRequest().body("Insufficient funds in the customer's account.");
                }

            } else {
                System.out.println("El cliente con número de cuenta " + accountNumber + " no fue encontrado.");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el pago."+ e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable Long id) {
        Payment deletedPayment = paymentService.deletePayment(id);
        if (deletedPayment != null) {
            return new ResponseEntity<>(deletedPayment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
