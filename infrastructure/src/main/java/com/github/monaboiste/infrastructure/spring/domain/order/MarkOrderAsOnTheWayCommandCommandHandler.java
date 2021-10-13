package com.github.monaboiste.infrastructure.spring.domain.order;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.infrastructure.spring.command.CommandHandler;
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
