package com.github.monaboiste.spring;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class SpringCommandBus implements CommandBus {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void fire(Command command) {
        log.info("[BUS] Publishing command: {}", command.getClass().getName());
        eventPublisher.publishEvent(command);
    }
}
