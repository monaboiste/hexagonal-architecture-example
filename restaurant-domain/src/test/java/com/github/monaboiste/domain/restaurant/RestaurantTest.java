package com.github.monaboiste.domain.restaurant;

import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantTest {

    private final FoodOrderDetails foodOrderDetails = new FoodOrderDetailsMock();
    private final FoodOrderNotifierMock foodOrderNotifier = new FoodOrderNotifierMock();
    private final RestaurantFacade restaurantFacade
            = new RestaurantFacade(foodOrderDetails, foodOrderNotifier);

    @Test
    void shouldNotificationWhenOrderIsReady() {
        // when
        restaurantFacade.getRestaurantService().prepareOrder(1L);
        // then
        assertThat(foodOrderNotifier.wasNotificationSent()).isTrue();
    }
}
