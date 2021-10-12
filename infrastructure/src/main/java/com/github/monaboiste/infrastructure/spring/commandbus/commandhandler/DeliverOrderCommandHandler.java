package com.github.monaboiste.infrastructure.spring.commandbus.commandhandler;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.infrastructure.spring.commandbus.CommandHandler;
import com.github.monaboiste.infrastructure.spring.commandbus.command.DeliverOrderCommand;
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
