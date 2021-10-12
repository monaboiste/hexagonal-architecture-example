package com.github.monaboiste.infrastructure.spring.commandbus.command;

public class DeliverOrderCommand extends Command {

    public DeliverOrderCommand(Long orderId) {
        super(orderId);
    }
}
