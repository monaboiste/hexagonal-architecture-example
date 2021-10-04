package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class FoodOrderServiceImpl implements FoodOrderService {

    private final FoodOrderDatabase foodOrderDatabase;

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
    public FoodOrderState getOrderState(Long orderId) {
        FoodOrderDto orderDto = foodOrderDatabase.findById(orderId);
        // TODO: throw if not exists
        return orderDto.getState();
    }

    @Override
    public void changeOrderState(Long orderId, FoodOrderState state) {
        FoodOrderDto orderDto = foodOrderDatabase.findById(orderId);

        FoodOrder.FoodOrderFactory orderFactory = FoodOrder.FoodOrderFactory.getInstance();
        FoodOrder order = orderFactory.from(orderDto);

        order.changeState(state);
        foodOrderDatabase.save(orderFactory.from(order));
    }
}
