package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderServiceImpl implements FoodOrderService {

    private final FoodOrderDatabase foodOrderDatabase;

    @Override
    public Long createOrder(String dishName) {
        FoodOrder.FoodOrderFactory orderFactory = FoodOrder.FoodOrderFactory.getInstance();
        FoodOrder order = orderFactory.createOrder(dishName);
        foodOrderDatabase.save(orderFactory.from(order));
        return order.getId();
    }

    @Override
    public FoodOrderState getOrderState(Long orderId) {
        FoodOrderDto orderDto = foodOrderDatabase.findById(orderId);
        // TODO: throw if not exists
        return orderDto.getState();
    }
}
