package com.servicepayment.customer.service;

import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> save(List<Customer> customers) {
        List<Customer> savedCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            savedCustomers.add(customerRepository.save(customer));
        }
        return savedCustomers;
    }
    public Customer getCustomerByAccountNumber(String account_number){
        Optional<Customer> customerOptional = customerRepository.findByFinancialInformation_AccountNumber(account_number);

        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            throw new IllegalArgumentException("No customer found with account number: " + account_number);
        }
    }


    public Customer updateCustomer(Customer updatedCustomer) {
        Long customerId = updatedCustomer.getCustomerId();

        if (customerId != null) {
            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

            if (optionalCustomer.isPresent()) {
                Customer existingCustomer = optionalCustomer.get();
                existingCustomer.setName(updatedCustomer.getName());
                existingCustomer.setLastname(updatedCustomer.getLastname());
                existingCustomer.setDni(updatedCustomer.getDni());

                return customerRepository.save(existingCustomer);
            } else {
                // Manejo de error, por ejemplo, lanzar una excepción indicando que el cliente no fue encontrado.
                return null; // Otra opción es devolver un ResponseEntity con un código de estado adecuado.
            }
        } else {
            // Manejo de error, por ejemplo, lanzar una excepción indicando que el identificador del cliente es nulo.
            return null; // Otra opción es devolver un ResponseEntity con un código de estado adecuado.
        }
    }
    public void delete(Long id){
        customerRepository.deleteById(id);
    }

}
