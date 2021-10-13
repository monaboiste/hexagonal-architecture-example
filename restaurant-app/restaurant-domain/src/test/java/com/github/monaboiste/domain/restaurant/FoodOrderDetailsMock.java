package com.github.monaboiste.domain.restaurant;

import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.restaurant.port.shared.FoodOrderDetailsDto;

class FoodOrderDetailsMock implements FoodOrderDetails {

    @Override
    public FoodOrderDetailsDto get(Long orderId) {
        return FoodOrderDetailsDto.builder()
                .foodOrderId(orderId)
                .dishName("pizza")
                .build();
    }
}
