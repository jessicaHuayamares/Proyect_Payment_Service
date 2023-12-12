package com.servicepayment.customer;
import com.servicepayment.customer.controller.CustomerController;
import com.servicepayment.customer.controller.PaymentController;
import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.entity.Financial_Information;
import com.servicepayment.customer.entity.Payment;
import com.servicepayment.customer.repository.CustomerRepository;
import com.servicepayment.customer.service.CustomerService;
import com.servicepayment.customer.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
public class PaymentApplicationTests {
    @Test
    public void testPaymentCreation() {
        // Crear una instancia de Payment
        Payment payment = new Payment();
        payment.setService("Internet");
        payment.setTypeservice("Servicio Privado");
        payment.setAmount(100.0f);
        payment.setAccountNumber("123456789");

        // Verificar que los campos se hayan establecido correctamente
        assertEquals("Internet", payment.getService());
        assertEquals("Servicio Privado", payment.getTypeservice());
        assertEquals(100.0f, payment.getAmount(), 0.001);
        assertEquals("123456789", payment.getAccountNumber());
    }


}

