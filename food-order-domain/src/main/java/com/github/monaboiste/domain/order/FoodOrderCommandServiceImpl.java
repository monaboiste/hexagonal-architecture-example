package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
class FoodOrderCommandServiceImpl implements FoodOrderCommandService {

    private final FoodOrderDatabase foodOrderDatabase;
    private final Logistics logistics;

    @Override
    public Long createOrder(String dishName, String address) {
        FoodOrder.FoodOrderFactory orderFactory = FoodOrder.FoodOrderFactory.getInstance();
        FoodOrder order = orderFactory.createOrder(dishName, address);

        log.info("Creating order: {} id {}", order.getDishName(), order.getId());
        foodOrderDatabase.save(orderFactory.from(order));
        log.info("Order: {} id {} has been saved", order.getDishName(), order.getId());

        return order.getId();
    }

    @Override
    public void markAsOnTheWay(Long orderId) {
        changeOrderState(orderId, FoodOrderState.ON_THE_WAY);
    }

    @Override
    public void markAsDelivered(Long orderId) {
        changeOrderState(orderId, FoodOrderState.DELIVERED);
    }

    @Override
    public void scheduleOrders() {
        Collection<FoodOrderDto> newOrders
                = foodOrderDatabase.findByState(FoodOrderState.NEW);
        Collection<FoodOrderDto> ordersOnTheWay
                = foodOrderDatabase.findByState(FoodOrderState.ON_THE_WAY);

        newOrders.forEach(order -> {
            log.info("[ORDER] Service: preparing order: {} {}",
                    order.getId(), order.getDishName());
            changeOrderState(order.getId(), FoodOrderState.SENT_TO_RESTAURANT);
            logistics.prepareDish(order.getId());
        });

        ordersOnTheWay.forEach(order -> {
            log.info("[ORDER] Service: delivering order: {} {}",
                    order.getId(), order.getDishName());
            logistics.deliver(order.getId());
        });
    }

    private void changeOrderState(Long orderId, FoodOrderState state) {
        FoodOrderDto orderDto = foodOrderDatabase.findById(orderId);

        FoodOrder.FoodOrderFactory orderFactory = FoodOrder.FoodOrderFactory.getInstance();
        FoodOrder order = orderFactory.from(orderDto);

        order.changeState(state);

        log.info("[ORDER] Order id: {} has changes state to: {}", orderId, state);

        foodOrderDatabase.save(orderFactory.from(order));
    }
}
