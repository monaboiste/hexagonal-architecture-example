package com.github.monaboiste.domain.restaurant;

import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import lombok.Getter;
import lombok.experimental.Accessors;

class FoodOrderNotifierMock implements FoodOrderNotifier {

    @Getter
    @Accessors(fluent = true)
    private boolean wasNotificationSent = false;

    @Override
    public void onOrderReady(Long orderId) {
        wasNotificationSent = true;
    }
}
