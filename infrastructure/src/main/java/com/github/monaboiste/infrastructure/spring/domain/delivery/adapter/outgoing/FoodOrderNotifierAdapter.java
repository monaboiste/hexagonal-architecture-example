package com.github.monaboiste.infrastructure.spring.domain.delivery.adapter.outgoing;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.infrastructure.spring.command.MarkOrderAsDeliveredCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
public class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void onDelivered(Long foodOrderId) {
        log.info("Publishing MarkOrderAsDeliveredCommand id: {}", foodOrderId);
        eventPublisher.publishEvent(new MarkOrderAsDeliveredCommand(foodOrderId));
    }
}
