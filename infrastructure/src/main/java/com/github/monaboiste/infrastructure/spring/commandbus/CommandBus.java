package com.github.monaboiste.infrastructure.spring.commandbus;

import com.github.monaboiste.infrastructure.spring.commandbus.command.Command;

public interface CommandBus {

    void fire(Command command);
}
