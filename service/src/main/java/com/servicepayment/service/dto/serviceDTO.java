package com.servicepayment.service.dto;

import lombok.Data;

@Data
public class serviceDTO {
    private Long serviceId;
    private String name;
    private String description;
    private Long typeServiceId;
}
