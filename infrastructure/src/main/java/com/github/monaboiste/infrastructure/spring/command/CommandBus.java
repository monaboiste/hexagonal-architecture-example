package com.github.monaboiste.infrastructure.spring.command;

public interface CommandBus {

    void fire(Command command);
}
