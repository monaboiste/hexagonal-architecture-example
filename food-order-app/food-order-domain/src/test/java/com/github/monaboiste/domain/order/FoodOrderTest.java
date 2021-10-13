package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodOrderTest {

    private final LogisticsMock logistics = new LogisticsMock();
    private final FoodOrderDatabase foodOrderDatabase = new InMemoryDatabaseMock();
    private final FoodOrderFacade foodOrderFacade = new FoodOrderFacade(foodOrderDatabase, logistics);

    @BeforeEach
    void setUp() {
        // TEMPORARY
        logistics.setFoodOrderFacade(foodOrderFacade);
    }

    @AfterEach
    void tearDown() {
        foodOrderDatabase.removeAll();
    }

    @Test
    void shouldCreateNewOrder() {
        // given
        String dishName = "pizza";
        String address = "ul. Wonka Policies 12/4, 66-555 Warsaw";
        // when
        Long orderId = foodOrderFacade.getFoodOrderCommandService()
                .createOrder(dishName, address);
        FoodOrderState orderState = foodOrderFacade.getFoodOrderQueryService()
                .findById(orderId).getState();
        // then
        assertThat(orderId).isNotZero();
        assertThat(orderState).isEqualTo(FoodOrderState.NEW);
    }

    @Test
    void shouldCorrectlyTransitionBetweenOrderStates() {
        // given
        String dishName = "pizza";
        String address = "ul. Wonka Policies 12/4, 66-555 Warsaw";
        // when
        Long orderId = foodOrderFacade.getFoodOrderCommandService()
                .createOrder(dishName, address);
        // then
        assertThat(foodOrderFacade.getFoodOrderQueryService().findById(orderId).getState())
                .isEqualTo(FoodOrderState.NEW);
        // and when cron is triggered and restaurant sends markAsOnTheWay command
        foodOrderFacade.getFoodOrderCommandService().scheduleOrders();
        // then
        assertThat(foodOrderFacade.getFoodOrderQueryService().findById(orderId).getState())
                .isEqualTo(FoodOrderState.ON_THE_WAY);
        // and when cron is triggered and delivery sends markAsDelivered command
        foodOrderFacade.getFoodOrderCommandService().scheduleOrders();
        // then
        assertThat(foodOrderFacade.getFoodOrderQueryService().findById(orderId).getState())
                .isEqualTo(FoodOrderState.DELIVERED);
    }
}
