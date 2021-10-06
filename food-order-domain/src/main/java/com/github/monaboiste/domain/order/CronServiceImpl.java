package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.incoming.CronService;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
public class CronServiceImpl implements CronService {
    private final FoodOrderDatabase foodOrderDatabase;
    private final Logistics logistics;

    @Override
    public void scheduleOrders() {
        Collection<FoodOrderDto> newOrders
                = foodOrderDatabase.findByState(FoodOrderState.NEW);
        Collection<FoodOrderDto> ordersOnTheWay
                = foodOrderDatabase.findByState(FoodOrderState.ON_THE_WAY);

        newOrders.forEach(order -> {
            log.info("[ORDER] Cron: preparing order: {} {}",
                    order.getId(), order.getDishName());
            logistics.prepareDish(order.getId());
        });

        ordersOnTheWay.forEach(order -> {
            log.info("[ORDER] Cron: delivering order: {} {}",
                    order.getId(), order.getDishName());
            logistics.deliver(order.getId());
        });
    }
}
