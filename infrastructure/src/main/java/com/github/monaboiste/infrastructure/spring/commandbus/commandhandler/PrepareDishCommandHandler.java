package com.github.monaboiste.infrastructure.spring.commandbus.commandhandler;

import com.github.monaboiste.domain.restaurant.port.incoming.CookCommandService;
import com.github.monaboiste.infrastructure.spring.commandbus.CommandHandler;
import com.github.monaboiste.infrastructure.spring.commandbus.command.PrepareDishCommand;
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
