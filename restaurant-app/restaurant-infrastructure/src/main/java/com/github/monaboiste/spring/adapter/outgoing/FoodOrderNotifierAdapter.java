package com.github.monaboiste.spring.adapter.outgoing;

import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.infrastructure.spring.command.CommandBus;
import com.github.monaboiste.infrastructure.spring.domain.order.MarkOrderAsOnTheWayCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final CommandBus commandBus;

    @Override
    public void onOrderReady(Long foodOrderId) {
        commandBus.fire(new MarkOrderAsOnTheWayCommand(foodOrderId));
    }
}