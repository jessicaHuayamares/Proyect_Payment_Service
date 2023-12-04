package com.servicepayment.service;

import com.servicepayment.entity.Customer;
import com.servicepayment.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerWithPayments(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));
    }

    public List<Customer> getcustomers(){
        return customerRepository.findAll();
    }

    //buscar typo de servicio a traves del id
    public Optional<Customer> getcustomers(Long id){
        return customerRepository.findById(id);
    }

    //guardar y actualizar

    public void saveOrUpdate(Customer customer){
        customerRepository.save(customer);
    }
    //borrar
    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}
