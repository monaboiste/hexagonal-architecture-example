package com.github.monaboiste.infrastructure.delivery.adapter.outgoing;

import com.github.monaboiste.commandbus.CommandBus;
import com.github.monaboiste.commandbus.command.MarkOrderAsDeliveredCommand;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final CommandBus commandBus;

    @Override
    public void onDelivered(Long foodOrderId) {
        commandBus.fire(new MarkOrderAsDeliveredCommand(foodOrderId));
    }
}
