package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderQueryServiceImpl implements FoodOrderQueryService {

    private final FoodOrderDatabase foodOrderDatabase;

    @Override
    public FoodOrderDto findById(Long orderId) {
        return foodOrderDatabase.findById(orderId);
    }
}
