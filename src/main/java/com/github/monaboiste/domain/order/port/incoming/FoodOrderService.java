package com.github.monaboiste.domain.order.port.incoming;

import com.github.monaboiste.domain.order.port.shared.FoodOrderState;

public interface FoodOrderService {

    Long createOrder(String dishName, String address);
    FoodOrderState getOrderState(Long orderId);
    void changeOrderState(Long orderId, FoodOrderState state);
}
