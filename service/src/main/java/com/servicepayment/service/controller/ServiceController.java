package com.servicepayment.service.controller;
import com.servicepayment.service.entity.service;
import org.springframework.stereotype.Service;

import com.servicepayment.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path="api/v2/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;


    @GetMapping
    public List<service> getAll(){
        return serviceService.getservices();

    }

    @GetMapping("/{serviceId}")
    public Optional<service> getBId(@PathVariable("serviceId") Long serviceId){
        return serviceService.getservices(serviceId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody service service) {
        serviceService.saveOrUpdate(service);
    }

    @DeleteMapping("/{serviceId}")
    public void saveUpdate(@PathVariable("serviceId") Long serviceId) {
        serviceService.delete(serviceId);
    }
}
