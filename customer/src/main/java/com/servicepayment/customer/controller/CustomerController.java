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

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerWithPayments(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getcustomers();

    }

    @GetMapping("/getB/{customerId}")
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
