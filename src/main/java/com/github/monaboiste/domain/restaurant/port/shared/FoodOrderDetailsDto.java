package com.github.monaboiste.domain.restaurant.port.shared;

import lombok.Data;

@Data
public class FoodOrderDetailsDto {

    private Long foodOrderId;
    private String dishName;
}
