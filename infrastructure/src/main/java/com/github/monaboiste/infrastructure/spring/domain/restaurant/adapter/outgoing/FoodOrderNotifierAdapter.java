package com.github.monaboiste.infrastructure.spring.domain.restaurant.adapter.outgoing;

import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.infrastructure.spring.commandbus.command.MarkOrderAsOnTheWayCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
class FoodOrderNotifierAdapter implements FoodOrderNotifier {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void onOrderReady(Long foodOrderId) {
        log.info("Publishing MarkOrderAsOnTheWayCommand id: {}", foodOrderId);
        eventPublisher.publishEvent(new MarkOrderAsOnTheWayCommand(foodOrderId));
    }
}
