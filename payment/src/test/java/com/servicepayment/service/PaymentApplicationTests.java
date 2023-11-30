package com.servicepayment.service;

import com.servicepayment.dto.PaymentDTO;
import com.servicepayment.entity.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PaymentApplicationTests {

	@Test
	public void test1() {
			PaymentDTO esperado=new PaymentDTO();
			PaymentService paymentService=new PaymentService();
			final Optional<Payment> resultado = paymentService.getpayments(2L);
			Assertions.assertEquals(esperado,resultado);
			
	}

}
