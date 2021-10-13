package com.github.monaboiste.commandbus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
class GlobalCommandHandler {

    private final ApplicationContext applicationContext;

    private final Map<Class<?>, CommandHandler<Command>> commandHandlerMap
            = new ConcurrentHashMap<>();

    @PostConstruct
    @SuppressWarnings("unchecked")
    private void populateCommandHandlerMap() {
        String[] commandHandlersBeanNames
                = applicationContext.getBeanNamesForType(CommandHandler.class);
        Stream.of(commandHandlersBeanNames)
                .map(name -> applicationContext.getBean(name, CommandHandler.class))
                .forEach(handler ->
                        commandHandlerMap.put(handler.getHandledClassType(), handler));
    }

    @EventListener
    public void handle(Command command) {
        log.info("[HANDLER] Handling command {} id: {}",
                command.getClass(), command.getOrderId());

        CommandHandler<Command> commandHandler
                = Optional.ofNullable(commandHandlerMap.get(command.getClass()))
                .orElseThrow(() -> new UnsupportedOperationException(
                        String.format("Handler for command %s has not been found",
                                command.getClass())));

        commandHandler.handle(command);
    }
}
