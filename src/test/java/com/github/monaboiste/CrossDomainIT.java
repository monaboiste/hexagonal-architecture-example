package com.github.monaboiste;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryService;
import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.CronService;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import com.github.monaboiste.domain.restaurant.port.incoming.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class CrossDomainIT {

    @Test
    void shouldCreateNewOrderAndDeliverTheOrder() {
        // given
        FoodOrderDatabase inMemoryDatabase = new FoodOrderDatabase() {

            private final ConcurrentHashMap<Long, FoodOrderDto> db
                    = new ConcurrentHashMap<>();

            @Override
            public void save(FoodOrderDto foodOrderDto) {
                db.put(foodOrderDto.getId(), foodOrderDto);
            }

            @Override
            public FoodOrderDto findById(Long orderId) {
                return db.get(orderId);
            }

            @Override
            public Collection<FoodOrderDto> findByState(FoodOrderState state) {
                return db.values().stream()
                        .filter((final var dto) -> dto.getState() == state)
                        .collect(Collectors.toList());
            }
        };

        Logistics logistics = new Logistics() {

            private final RestaurantService restaurantService;
            private final DeliveryService deliveryService;

            @Override
            public void prepareDish(Long foodOrderId) {
                log.info("Preparing order: {}", foodOrderId);
            }

            @Override
            public void deliver(Long foodOrderId) {
                log.info("Delivering order: {}", foodOrderId);
            }
        };

        FoodOrderFacade foodOrderFacade = new FoodOrderFacade(inMemoryDatabase, logistics);
        FoodOrderService foodOrderService = foodOrderFacade.getFoodOrderService();
        CronService cronService = foodOrderFacade.getCronService();
        String dishName = "pizza";
        String address = "ul. Wojska Polskiego 12/4, 66-555 Warszawa";
        // when
        Long orderId = foodOrderService.createOrder(dishName, address);
        FoodOrderState orderState = foodOrderService.getOrderState(orderId);
        // then
        assertThat(orderId).isNotZero();
        assertThat(orderState).isEqualTo(FoodOrderState.NEW);

        // and
        // when
        cronService.scheduleOrders();
        orderState = foodOrderService.getOrderState(orderId);
        // then
        assertThat(orderState).isEqualTo(FoodOrderState.ON_THE_WAY);

        // and
        // when
        cronService.scheduleOrders();
        orderState = foodOrderService.getOrderState(orderId);
        // then
        assertThat(orderState).isEqualTo(FoodOrderState.DELIVERED);
    }
}
