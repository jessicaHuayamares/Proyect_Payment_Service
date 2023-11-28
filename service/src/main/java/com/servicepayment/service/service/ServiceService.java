package com.servicepayment.service.service;

import com.servicepayment.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.servicepayment.service.entity.service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<service> getservices(){
        return serviceRepository.findAll();
    }

    //buscar typo de servicio a traves del id
    public Optional<service> getservices(Long id){
        return serviceRepository.findById(id);
    }

    //guardar y actualizar

    public void saveOrUpdate(service service){
        serviceRepository.save(service);
    }
    //borrar
    public void delete(Long id){
        serviceRepository.deleteById(id);
    }
}
