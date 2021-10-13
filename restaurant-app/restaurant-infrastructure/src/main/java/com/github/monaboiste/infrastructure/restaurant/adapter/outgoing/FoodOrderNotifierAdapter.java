package com.github.monaboiste.infrastructure.restaurant.adapter.outgoing;

import com.github.monaboiste.commandbus.CommandBus;
import com.github.monaboiste.commandbus.command.MarkOrderAsOnTheWayCommand;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final CommandBus commandBus;

    @Override
    public void onOrderReady(Long foodOrderId) {
        commandBus.fire(new MarkOrderAsOnTheWayCommand(foodOrderId));
    }
}
