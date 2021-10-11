package com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing;

import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.infrastructure.spring.command.DeliverOrderCommand;
import com.github.monaboiste.infrastructure.spring.command.PrepareDishCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
public class DefaultLogistics implements Logistics {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void prepareDish(Long foodOrderId) {
        log.info("Publishing PrepareOrderCommand id: {}", foodOrderId);
        eventPublisher.publishEvent(new PrepareDishCommand(foodOrderId));
    }

    @Override
    public void deliver(Long foodOrderId) {
        log.info("Publishing DeliverOrderCommand id: {}", foodOrderId);
        eventPublisher.publishEvent(new DeliverOrderCommand(foodOrderId));
    }
}
