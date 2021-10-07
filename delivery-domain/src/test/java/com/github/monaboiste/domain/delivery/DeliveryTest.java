package com.github.monaboiste.domain.delivery;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeliveryTest {

    private final FoodOrderDetails foodOrderDetails = new FoodOrderDetailsMock();
    private final FoodOrderNotifierMock foodOrderNotifier = new FoodOrderNotifierMock();
    private final DeliveryFacade deliveryFacade
            = new DeliveryFacade(foodOrderDetails, foodOrderNotifier);

    @Test
    void shouldNotificationWhenOrderIsDelivered() {
        // when
        deliveryFacade.getDeliveryCommandService().deliver(1L);
        // then
        assertThat(foodOrderNotifier.wasNotificationSent()).isTrue();
    }
}
