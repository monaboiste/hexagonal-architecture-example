package com.github.monaboiste.domain.delivery;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.delivery.port.shared.FoodOrderDetailsDto;

class FoodOrderDetailsMock implements FoodOrderDetails {

    @Override
    public FoodOrderDetailsDto get(Long orderId) {
        return FoodOrderDetailsDto.builder()
                .foodOrderId(orderId)
                .address("ul. Wonka Policies 12/4, 66-555 Warsaw")
                .build();
    }
}
