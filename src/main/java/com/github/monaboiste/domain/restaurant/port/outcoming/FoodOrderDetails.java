package com.github.monaboiste.domain.restaurant.port.outcoming;

import com.github.monaboiste.domain.restaurant.port.shared.FoodOrderDetailsDto;

public interface FoodOrderDetails {

    FoodOrderDetailsDto get(Long orderId);
}
