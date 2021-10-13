package com.github.monaboiste.spring;

public interface CommandBus {

    void fire(Command command);
}
