package com.servicepayment.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="tbl_typeService")
public class typeservice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeServiceId;

    @Column(nullable = false)
    private String name;
}
