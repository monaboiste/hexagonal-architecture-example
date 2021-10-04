package com.github.monaboiste.domain.restaurant.port.outcoming;

public interface FoodOrderNotifier {

    void onOrderReady(Long orderId);
}
