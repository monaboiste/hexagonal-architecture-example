package com.github.monaboiste.infrastructure.spring;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.infrastructure.spring.command.CommandHandler;
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
