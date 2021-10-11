package com.github.monaboiste.infrastructure.spring.commandbus;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import com.github.monaboiste.domain.restaurant.port.incoming.CookCommandService;
import com.github.monaboiste.infrastructure.spring.commandbus.command.Command;
import com.github.monaboiste.infrastructure.spring.commandbus.command.DeliverOrderCommand;
import com.github.monaboiste.infrastructure.spring.commandbus.command.MarkOrderAsDeliveredCommand;
import com.github.monaboiste.infrastructure.spring.commandbus.command.MarkOrderAsOnTheWayCommand;
import com.github.monaboiste.infrastructure.spring.commandbus.command.PrepareDishCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class SpringCommandHandler implements CommandHandler {

    private final FoodOrderCommandService foodOrderCommandService;
    private final CookCommandService cookCommandService;
    private final DeliveryCommandService deliveryCommandService;

    @EventListener
    @Override
    public void handle(Command command) {
        log.info("[HANDLER] Handling command: {}",
                command.getClass().getName());

        if (command instanceof PrepareDishCommand) {
            cookCommandService.prepareOrder(
                    ((PrepareDishCommand) command).getFoodOrderId());
            return;
        } else if (command instanceof MarkOrderAsOnTheWayCommand) {
            foodOrderCommandService.markAsOnTheWay(
                    ((MarkOrderAsOnTheWayCommand) command).getFoodOrderId());
            return;
        } else if (command instanceof DeliverOrderCommand) {
            deliveryCommandService.deliver(
                    ((DeliverOrderCommand) command).getFoodOrderId());
            return;
        } else if (command instanceof MarkOrderAsDeliveredCommand) {
            foodOrderCommandService.markAsDelivered(
                    ((MarkOrderAsDeliveredCommand) command).getFoodOrderId());
            return;
        }
        throw new UnsupportedOperationException(
                String.format("Unknown command %s passed to the handler",
                        command.getClass().getName())
        );
    }
}
