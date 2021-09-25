package com.github.monaboiste.domain;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DomainTest {

    @Test
    void exampleDomainTest() {
        FoodOrderFacade foodOrderFacade = new FoodOrderFacade(new InMemoryFoodOrderDatabase());
        FoodOrderService foodOrderService = foodOrderFacade.getFoodOrderService();

        Long orderId = foodOrderService.createOrder("burder");
        FoodOrderState orderState = foodOrderService.getOrderState(orderId);

        assertThat(orderId).isEqualTo(1L);
        assertThat(orderState).isEqualTo(FoodOrderState.NEW);
    }
}
