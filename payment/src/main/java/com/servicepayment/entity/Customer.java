package com.servicepayment.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name="tbl_accounts")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @Column(name = "phone_number", nullable = false)
    private String phone;

    public void setAccountId(long l) {
    }

    public void setAccountNumber(String number) {
    }

    public void setAmountAvailable(double v) {
    }
}
