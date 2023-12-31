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
    private Long paymentId;

    @NotNull
    @Column(name = "service_name", nullable = false)
    private String service;

    @NotNull
    @Column(name = "typeservice_name", nullable = false)
    private String typeservice;

    @NotNull
    @Column(name = "amount", nullable = false)
    private float amount;

    @NotNull
    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

/*    @ManyToOne
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
    }*/
}
