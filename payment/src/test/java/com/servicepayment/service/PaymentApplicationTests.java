
package com.servicepayment.service;
import com.servicepayment.Controller.PaymentController;
import com.servicepayment.entity.Customer;
import com.servicepayment.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class PaymentApplicationTests {
    @Test
    public void testMakePayment() {
        // Crear un mock de PaymentService
        PaymentService paymentServiceMock = mock(PaymentService.class);

        // Crear una instancia de PaymentController utilizando el mock de PaymentService
        PaymentController paymentController = new PaymentController(paymentServiceMock);

        // Definir datos de prueba
        Customer customer = new Customer();
        customer.setAccountId(1L);
        customer.setAccountNumber("123456789");
        customer.setAmountAvailable(1000.0);

        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setAccountNumber("123");
        payment.setServiceId(456);
        payment.setAmount(50);

        when(paymentServiceMock.makePayment(payment)).thenReturn(payment);

        ResponseEntity<Payment> response = paymentController.makePayment(payment);

        verify(paymentServiceMock, times(1)).makePayment(payment);
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(payment, response.getBody())
        );
    }

}


