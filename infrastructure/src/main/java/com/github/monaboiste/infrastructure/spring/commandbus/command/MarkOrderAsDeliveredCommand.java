package com.github.monaboiste.infrastructure.spring.commandbus.command;

public class MarkOrderAsDeliveredCommand extends Command {

    public MarkOrderAsDeliveredCommand(Long orderId) {
        super(orderId);
    }
}
