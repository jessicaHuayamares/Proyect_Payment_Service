package com.servicepayment.demo.controller;

import com.servicepayment.demo.entity.typeservice;
import com.servicepayment.demo.service.typeserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/typeservices")
public class typeserviceController {
    @Autowired
    private typeserviceService typeserviceService;

    @GetMapping
    public List<typeservice> getAll(){
        return typeserviceService.gettypeservices();

    }

    @GetMapping("/{typeserviceId}")
    public Optional<typeservice> getBId(@PathVariable("typeserviceId") Long typeserviceId){
        return typeserviceService.gettypeservices(typeserviceId);

    }

    @PostMapping
    public void saveUpdate(@RequestBody typeservice typeservice) {
        typeserviceService.saveOrUpdate(typeservice);
    }

    @DeleteMapping("/{typeserviceId}")
    public void saveUpdate(@PathVariable("typeserviceId") Long typeserviceId) {
        typeserviceService.delete(typeserviceId);
    }
}
