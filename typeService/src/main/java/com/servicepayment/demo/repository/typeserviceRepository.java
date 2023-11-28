package com.servicepayment.demo.repository;

import com.servicepayment.demo.entity.typeservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface typeserviceRepository extends JpaRepository<typeservice, Long>{

}

