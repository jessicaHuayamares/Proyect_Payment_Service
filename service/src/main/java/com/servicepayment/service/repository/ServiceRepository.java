package com.servicepayment.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.servicepayment.service.entity.service;
@Repository
public interface ServiceRepository extends JpaRepository<service, Long> {
}
