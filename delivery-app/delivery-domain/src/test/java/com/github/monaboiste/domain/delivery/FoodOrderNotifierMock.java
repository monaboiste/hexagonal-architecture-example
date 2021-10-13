package com.github.monaboiste.domain.delivery;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import lombok.Getter;
import lombok.experimental.Accessors;

class FoodOrderNotifierMock implements FoodOrderNotifier {

    @Getter
    @Accessors(fluent = true)
    private boolean wasNotificationSent = false;

    @Override
    public void onDelivered(Long foodOrderId) {
        wasNotificationSent = true;
    }
}
