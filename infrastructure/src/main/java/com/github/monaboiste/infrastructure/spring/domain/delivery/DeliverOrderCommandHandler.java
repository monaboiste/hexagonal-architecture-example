package com.github.monaboiste.infrastructure.spring.domain.delivery;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.infrastructure.spring.command.CommandHandler;
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
