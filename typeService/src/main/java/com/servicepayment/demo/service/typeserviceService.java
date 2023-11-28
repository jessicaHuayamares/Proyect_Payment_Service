package com.servicepayment.demo.service;

import com.servicepayment.demo.entity.typeservice;
import com.servicepayment.demo.repository.typeserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class typeserviceService {
    @Autowired
    typeserviceRepository typeserviceRepository;

    public List<typeservice> gettypeservices(){
        return typeserviceRepository.findAll();
    }

    //buscar typo de servicio a traves del id
    public Optional<typeservice> gettypeservices(Long id){
        return typeserviceRepository.findById(id);
    }

    //guardar y actualizar

    public void saveOrUpdate(typeservice type_service){
        typeserviceRepository.save(type_service);
    }
    //borrar
    public void delete(Long id){
        typeserviceRepository.deleteById(id);
    }
}
