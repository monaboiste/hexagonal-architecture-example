package com.github.monaboiste.infrastructure.restaurant;

import com.github.monaboiste.commandbus.CommandHandler;
import com.github.monaboiste.commandbus.command.PrepareDishCommand;
import com.github.monaboiste.domain.restaurant.port.incoming.CookCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PrepareDishCommandHandler
        implements CommandHandler<PrepareDishCommand> {

    private final CookCommandService cookCommandService;

    @Override
    public void handle(PrepareDishCommand command) {
        cookCommandService.prepareOrder(command.getOrderId());
    }
}
