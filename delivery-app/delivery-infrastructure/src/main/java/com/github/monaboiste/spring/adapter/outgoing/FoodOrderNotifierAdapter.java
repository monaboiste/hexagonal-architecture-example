package com.github.monaboiste.spring.adapter.outgoing;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.infrastructure.spring.command.CommandBus;
import com.github.monaboiste.infrastructure.spring.domain.order.MarkOrderAsDeliveredCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final CommandBus commandBus;

    @Override
    public void onDelivered(Long foodOrderId) {
        commandBus.fire(new MarkOrderAsDeliveredCommand(foodOrderId));
    }
}
