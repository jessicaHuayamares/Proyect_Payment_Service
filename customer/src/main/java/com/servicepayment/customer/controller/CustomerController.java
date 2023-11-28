package com.servicepayment.customer.controller;

import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v4/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getcustomers();

    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getBId(@PathVariable("customerId") Long customerId){
        return customerService.getcustomers(customerId);

    }

    @PostMapping
    public void saveUpdate(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
    }

    @DeleteMapping("/{customerId}")
    public void saveUpdate(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }
}
