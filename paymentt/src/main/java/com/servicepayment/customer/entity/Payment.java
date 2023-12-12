package com.servicepayment.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name="tbl_payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
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

    @Column(name = "account_number", nullable = false)
    private String accountNumber;
}
