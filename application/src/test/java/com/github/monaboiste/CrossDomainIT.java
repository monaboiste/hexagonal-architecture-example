package com.monaboiste.github;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrossDomainIT {

    @Autowired
    private FoodOrderCommandService foodOrderCommandService;

    @Autowired
    private FoodOrderQueryService foodOrderQueryService;

    @Test
    void shouldCreateNewOrderAndDeliverTheOrder() {
        // given
        String dishName = "pizza";
        String address = "ul. Wonka Polices 12/4, 66-555 Warsaw";
        // when
        Long orderId = foodOrderCommandService.createOrder(dishName, address);
        // then
        assertThat(foodOrderQueryService.findById(orderId).getState())
                .isEqualTo(FoodOrderState.NEW);
        // and when
        foodOrderCommandService.scheduleOrders();
        // then
        assertThat(foodOrderQueryService.findById(orderId).getState())
                .isEqualTo(FoodOrderState.ON_THE_WAY);
        // and when
        foodOrderCommandService.scheduleOrders();
        // then
        assertThat(foodOrderQueryService.findById(orderId).getState())
                .isEqualTo(FoodOrderState.DELIVERED);
    }
}
