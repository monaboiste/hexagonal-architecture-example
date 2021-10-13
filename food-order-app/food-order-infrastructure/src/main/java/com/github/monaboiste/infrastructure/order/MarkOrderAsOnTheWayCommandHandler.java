package com.github.monaboiste.infrastructure.order;

import com.github.monaboiste.commandbus.CommandHandler;
import com.github.monaboiste.commandbus.command.MarkOrderAsOnTheWayCommand;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MarkOrderAsOnTheWayCommandHandler
        implements CommandHandler<MarkOrderAsOnTheWayCommand> {

    private final FoodOrderCommandService foodOrderCommandService;

    @Override
    public void handle(MarkOrderAsOnTheWayCommand command) {
        foodOrderCommandService.markAsOnTheWay(command.getOrderId());
    }
}
