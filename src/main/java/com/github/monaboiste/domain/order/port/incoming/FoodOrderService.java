package com.github.monaboiste.domain.order.port.incoming;

import com.github.monaboiste.domain.order.port.shared.FoodOrderState;

public interface FoodOrderService {

    Long createOrder(String dishName);
    FoodOrderState getOrderState(Long orderId);
}
