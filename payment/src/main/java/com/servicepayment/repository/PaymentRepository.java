package com.servicepayment.repository;

import com.servicepayment.entity.Customer;
import com.servicepayment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
