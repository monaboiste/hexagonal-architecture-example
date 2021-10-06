package com.github.monaboiste.domain.order.port.shared;

import lombok.Data;

@Data
public class FoodOrderDto {

    private Long id;
    private String dishName;
    private String address;
    private FoodOrderState state;
}
