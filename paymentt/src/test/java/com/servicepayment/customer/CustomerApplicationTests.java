package com.servicepayment.customer;

import com.servicepayment.customer.controller.CustomerController;
import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.entity.Financial_Information;
import com.servicepayment.customer.repository.CustomerRepository;
import com.servicepayment.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
@SpringBootTest
class CustomerApplicationTests {

		@Mock
		private CustomerRepository customerRepository;
		@Mock
		private CustomerService customerService;
		@InjectMocks
		private CustomerController customerController;
		@Test
		public void testSaveOrUpdate() {
			Customer customer = new Customer();
			customer.setCustomerId(1L);
			customer.setName("John");
			customer.setLastname("Doe");
			customer.setDni("123456789");

			Financial_Information financialInformation = new Financial_Information();
			financialInformation.setId(1L);
			financialInformation.setAccountType("Savings");
			financialInformation.setAccountNumber("1234567890");
			financialInformation.setAmount(1000.0f);

			customer.setFinancialInformation(financialInformation);
			customerController.saveUpdate(customer);
			verify(customerService, times(1)).saveOrUpdate(customer);
		}
	}


