package com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing;

import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.infrastructure.spring.command.CommandBus;
import com.github.monaboiste.infrastructure.spring.domain.delivery.DeliverOrderCommand;
import com.github.monaboiste.infrastructure.spring.domain.restaurant.PrepareDishCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DefaultLogistics implements Logistics {

    private final CommandBus commandBus;

    @Override
    public void prepareDish(Long foodOrderId) {
        commandBus.fire(new PrepareDishCommand(foodOrderId));
    }

    @Override
    public void deliver(Long foodOrderId) {
        commandBus.fire(new DeliverOrderCommand(foodOrderId));
    }
}
