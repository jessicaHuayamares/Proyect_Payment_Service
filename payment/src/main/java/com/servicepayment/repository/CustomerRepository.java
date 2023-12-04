package com.servicepayment.repository;

import com.servicepayment.entity.Customer;
import com.servicepayment.entity.Payment;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
