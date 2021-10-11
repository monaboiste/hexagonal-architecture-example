package com.github.monaboiste.infrastructure.spring.domain.delivery.adapter.incoming;

import com.github.monaboiste.domain.delivery.DeliveryFacade;
import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.infrastructure.spring.commandbus.command.DeliverOrderCommand;
import lombok.experimental.Delegate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
class DeliveryCommandAppService implements DeliveryCommandService {

    @Delegate
    private final DeliveryCommandService deliveryCommandServiceDelegate;

    public DeliveryCommandAppService(DeliveryFacade deliveryFacade) {
        this.deliveryCommandServiceDelegate = deliveryFacade.getDeliveryCommandService();
    }

    @EventListener
    public void handlePrepareOrder(DeliverOrderCommand deliverOrderCommand) {
        this.deliver(deliverOrderCommand.getFoodOrderId());
    }
}
