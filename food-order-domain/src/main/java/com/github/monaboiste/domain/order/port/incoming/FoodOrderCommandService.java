package com.github.monaboiste.domain.order.port.incoming;

public interface FoodOrderCommandService {

    Long createOrder(String dishName, String address);
    void markAsOnTheWay(Long orderId);
    void markAsDelivered(Long orderId);
    void scheduleOrders();
}
