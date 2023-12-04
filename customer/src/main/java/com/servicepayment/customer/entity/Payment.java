package com.servicepayment.customer.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Payment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long transactionId;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        private Customer customer;

        @Column(name = "account_number", nullable = false)
        private int accountNumber;
        private int serviceId;
        private float amount;

        @Temporal(TemporalType.TIMESTAMP)
        private Date transactionDate;

}
