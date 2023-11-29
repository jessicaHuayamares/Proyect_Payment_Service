package com.servicepayment.demo.dto;
import lombok.*;
import lombok.Data;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipeServiceDTO {
    private Long typeServiceId;
    private String name;
}
