package com.servicepayment.customer.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import com.servicepayment.customer.entity.Payment;

import java.util.List;

@Data
@Entity
@Table(name="tbl_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull
    private String nombre;

    private String dni;

    @Column(nullable = false)
    private String accountNumber;
    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;
}
