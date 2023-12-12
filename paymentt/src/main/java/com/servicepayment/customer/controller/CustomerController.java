package com.servicepayment.customer.controller;

import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v4/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = customerService.getAll();
        if(customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomerById(id);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{account_number}")
    public ResponseEntity<Customer> getCustomerByAccountNumber(@PathVariable("account_number") String account_number){
        Customer customer = customerService.getCustomerByAccountNumber(account_number);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }


    @PostMapping
    public void saveUpdate(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
    }

    @PostMapping("/group")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return customerService.save(customers);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @PutMapping("/update/{account_number}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("account_number") String accountNumber, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerByAccountNumber(accountNumber);
        // Actualizar los campos necesarios del cliente existente
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setFinancialInformation(updatedCustomer.getFinancialInformation());

        // Luego, realiza la actualización en el servicio
        Customer updated = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{customerId}")
    public void saveUpdate(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }


}
