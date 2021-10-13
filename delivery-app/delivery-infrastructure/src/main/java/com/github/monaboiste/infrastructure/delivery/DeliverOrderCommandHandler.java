package com.github.monaboiste.infrastructure.delivery;

import com.github.monaboiste.commandbus.CommandHandler;
import com.github.monaboiste.commandbus.command.DeliverOrderCommand;
import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DeliverOrderCommandHandler
        implements CommandHandler<DeliverOrderCommand> {
    private final DeliveryCommandService deliveryCommandService;

    @Override
    public void handle(DeliverOrderCommand command) {
        deliveryCommandService.deliver(command.getOrderId());
    }
}
