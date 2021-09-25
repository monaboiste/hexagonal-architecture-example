package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import lombok.Getter;

@Getter
public class FoodOrderFacade {

    private final FoodOrderService foodOrderService;

    public FoodOrderFacade(FoodOrderDatabase foodOrderDatabase) {
        this.foodOrderService = new FoodOrderServiceImpl(foodOrderDatabase);
    }
}
