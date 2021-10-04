package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.CronService;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import lombok.Getter;

@Getter
public class FoodOrderFacade {

    private final FoodOrderService foodOrderService;
    private final CronService cronService;

    public FoodOrderFacade(FoodOrderDatabase foodOrderDatabase, Logistics logistics) {
        this.foodOrderService = new FoodOrderServiceImpl(foodOrderDatabase);
        this.cronService = new CronServiceImpl(foodOrderDatabase, logistics);
    }
}
