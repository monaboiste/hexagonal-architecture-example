package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LogisticsMock implements Logistics {

    @Setter
    private FoodOrderFacade foodOrderFacade;

    @Override
    public void prepareDish(Long foodOrderId) {
        log.info("[ORDER] Logistics: preparing order: {}", foodOrderId);
        foodOrderFacade.getFoodOrderCommandService()
                .markAsOnTheWay(foodOrderId);
    }

    @Override
    public void deliver(Long foodOrderId) {
        log.info("[ORDER] Logistics: delivering order: {}", foodOrderId);
        foodOrderFacade.getFoodOrderCommandService()
                .markAsDelivered(foodOrderId);
    }
}
