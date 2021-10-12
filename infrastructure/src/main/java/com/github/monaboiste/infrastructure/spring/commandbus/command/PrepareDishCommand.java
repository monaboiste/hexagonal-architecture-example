package com.github.monaboiste.infrastructure.spring.commandbus.command;

public class PrepareDishCommand extends Command {

    public PrepareDishCommand(Long orderId) {
        super(orderId);
    }
}
