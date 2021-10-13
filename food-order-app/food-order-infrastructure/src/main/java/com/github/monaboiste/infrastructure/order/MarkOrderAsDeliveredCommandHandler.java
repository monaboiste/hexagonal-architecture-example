package com.github.monaboiste.infrastructure.order;

import com.github.monaboiste.commandbus.CommandHandler;
import com.github.monaboiste.commandbus.command.MarkOrderAsDeliveredCommand;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MarkOrderAsDeliveredCommandHandler
        implements CommandHandler<MarkOrderAsDeliveredCommand> {

    private final FoodOrderCommandService foodOrderCommandService;

    @Override
    public void handle(MarkOrderAsDeliveredCommand command) {
        foodOrderCommandService.markAsDelivered(command.getOrderId());
    }
}
