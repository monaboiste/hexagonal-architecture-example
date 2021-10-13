package com.github.monaboiste.infrastructure.order.adapter.outgoing;

import com.github.monaboiste.commandbus.CommandBus;
import com.github.monaboiste.commandbus.command.DeliverOrderCommand;
import com.github.monaboiste.commandbus.command.PrepareDishCommand;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
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
