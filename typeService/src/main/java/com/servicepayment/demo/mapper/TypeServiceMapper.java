package com.servicepayment.demo.mapper;

import org.mapstruct.Mapper;
import com.servicepayment.demo.dto.TipeServiceDTO;
import com.servicepayment.demo.entity.typeservice;
@Mapper(componentModel = "spring")

public interface TypeServiceMapper {
    typeservice toEntity(TipeServiceDTO typeServiceDTO);
    TipeServiceDTO toDTO(typeservice typeservice);
}
