package com.servicepayment.customer.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tbl_financial_information")
public class Financial_Information {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "accountType", nullable = false)
        private String accountType;

        @Column(name = "account_number", nullable = false)
        private String accountNumber;

        @Getter
        @Column(name = "amount", nullable = false)
        private float amount;

}
