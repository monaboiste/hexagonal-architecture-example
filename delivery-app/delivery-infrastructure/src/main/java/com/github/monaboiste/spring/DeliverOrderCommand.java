package com.github.monaboiste.spring;

import com.github.monaboiste.infrastructure.spring.command.Command;

public class DeliverOrderCommand extends Command {

    public DeliverOrderCommand(Long orderId) {
        super(orderId);
    }
}
