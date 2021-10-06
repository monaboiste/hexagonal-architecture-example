package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodOrderTest {

    private final FoodOrderDatabase foodOrderDatabase
            = new InMemoryDatabaseMock();
    private final FoodOrderService foodOrderService
            = new FoodOrderServiceImpl(foodOrderDatabase);

    @AfterEach
    void tearDown() {
        foodOrderDatabase.removeAll();
    }

    @Test
    void shouldCreateNewOrder() {
        // given
        String dishName = "pizza";
        String address = "ul. Wojska Polskiego 12/4, 66-555 Warszawa";
        // when
        Long orderId = foodOrderService.createOrder(dishName, address);
        FoodOrderState orderState = foodOrderService.getOrderState(orderId);
        // then
        assertThat(orderId).isEqualTo(1L);
        assertThat(orderState).isEqualTo(FoodOrderState.NEW);
    }
}
