package com.github.monaboiste.infrastructure.spring.commandbus.commandhandler;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.infrastructure.spring.commandbus.CommandHandler;
import com.github.monaboiste.infrastructure.spring.commandbus.command.MarkOrderAsOnTheWayCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MarkOrderAsOnTheWayCommandCommandHandler
        implements CommandHandler<MarkOrderAsOnTheWayCommand> {

    private final FoodOrderCommandService foodOrderCommandService;

    @Override
    public void handle(MarkOrderAsOnTheWayCommand command) {
        foodOrderCommandService.markAsOnTheWay(command.getOrderId());
    }
}
