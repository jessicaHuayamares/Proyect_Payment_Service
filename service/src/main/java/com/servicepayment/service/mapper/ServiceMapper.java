package com.servicepayment.service.mapper;

import com.servicepayment.service.dto.serviceDTO;
import com.servicepayment.service.entity.service;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    service toEntity(serviceDTO serviceDTO);
    serviceDTO toDTO(service service);
}
