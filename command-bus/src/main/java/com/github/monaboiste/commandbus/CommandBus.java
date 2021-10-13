package com.github.monaboiste.commandbus;

public interface CommandBus {

    void fire(Command command);
}
