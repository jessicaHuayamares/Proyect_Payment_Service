package com.servicepayment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
@Entity
@Table(name="tbl_payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    private int serviceId;
    private float amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    public void setCreateAt(Date date) {
    }
}
