package com.github.monaboiste.infrastructure.spring.domain.delivery.adapter.outgoing;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.infrastructure.spring.commandbus.CommandBus;
import com.github.monaboiste.infrastructure.spring.commandbus.command.MarkOrderAsDeliveredCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final CommandBus commandBus;

    @Override
    public void onDelivered(Long foodOrderId) {
        commandBus.fire(new MarkOrderAsDeliveredCommand(foodOrderId));
    }
}
