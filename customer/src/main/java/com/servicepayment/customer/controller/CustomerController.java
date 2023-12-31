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
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomerById(id);
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

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public void saveUpdate(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }



}
