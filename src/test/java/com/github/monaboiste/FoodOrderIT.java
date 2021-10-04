package com.github.monaboiste;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FoodOrderIT {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private FoodOrderService foodOrderService;

    @Test
    void shouldLoadApplicationContext() {
        assertThat(applicationContext).isNotNull();
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
