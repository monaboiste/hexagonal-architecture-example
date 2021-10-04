package com.github.monaboiste.domain.delivery.port.outcoming;

public interface FoodOrderNotifier {

    void onDelivered(Long foodOrderId);
}
