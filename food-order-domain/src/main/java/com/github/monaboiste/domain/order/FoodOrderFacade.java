package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import lombok.Getter;

/**
 * Facade takes secondary ports and return primary ports.
 */
@Getter
public class FoodOrderFacade {

    private final FoodOrderCommandService foodOrderCommandService;
    private final FoodOrderQueryService foodOrderQueryService;

    public FoodOrderFacade(FoodOrderDatabase foodOrderDatabase,
                           Logistics logistics) {
        this.foodOrderCommandService
                = new FoodOrderCommandServiceImpl(foodOrderDatabase, logistics);
        this.foodOrderQueryService
                = new FoodOrderQueryServiceImpl(foodOrderDatabase);
    }
}
