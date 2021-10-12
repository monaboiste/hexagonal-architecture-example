package com.github.monaboiste.infrastructure.spring.commandbus;

import com.github.monaboiste.infrastructure.spring.commandbus.command.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
class SpringCommandHandler {

    private final ApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
    @EventListener
    public void handle(Command command) {
        log.info("[HANDLER] Handling command {} id: {}",
                command.getClass(), command.getOrderId());

        String[] commandHandlersBeanNames = applicationContext.getBeanNamesForType(CommandHandler.class);
        CommandHandler<Command> commandHandler = Stream.of(commandHandlersBeanNames)
                .map(name -> applicationContext.getBean(name, CommandHandler.class))
                .filter(handler -> handler.getHandledClassType() == command.getClass())
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException(
                        String.format("Handler for command %s has not been found",
                                command.getClass())));

        commandHandler.handle(command);
    }
}
