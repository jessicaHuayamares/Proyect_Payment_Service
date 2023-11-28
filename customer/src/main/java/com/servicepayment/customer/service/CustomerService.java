package com.servicepayment.customer.service;

import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

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
