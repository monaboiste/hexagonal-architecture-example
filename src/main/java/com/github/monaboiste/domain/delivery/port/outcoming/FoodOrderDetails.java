package com.github.monaboiste.domain.delivery.port.outcoming;

import com.github.monaboiste.domain.delivery.port.shared.FoodOrderDetailsDto;

public interface FoodOrderDetails {

    FoodOrderDetailsDto get(Long orderId);
}
