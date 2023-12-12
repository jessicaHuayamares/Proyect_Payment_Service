package com.servicepayment.customer.repository;

import com.servicepayment.customer.entity.Customer;
import com.servicepayment.customer.entity.Financial_Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByFinancialInformation(Financial_Information financial_information);

    Optional<Customer> findByFinancialInformation_AccountNumber(String accountNumber);
}
