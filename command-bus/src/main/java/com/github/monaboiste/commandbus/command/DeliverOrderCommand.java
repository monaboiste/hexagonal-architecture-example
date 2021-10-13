package com.github.monaboiste.commandbus.command;

import com.github.monaboiste.commandbus.Command;

public class DeliverOrderCommand extends Command {

    public DeliverOrderCommand(Long orderId) {
        super(orderId);
    }
}
