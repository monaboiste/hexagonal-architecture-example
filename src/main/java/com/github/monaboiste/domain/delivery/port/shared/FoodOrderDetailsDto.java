package com.github.monaboiste.domain.delivery.port.shared;

import lombok.Data;

@Data
public class FoodOrderDetailsDto {

    private Long foodOrderId;
    private String address;
}
