package com.github.monaboiste.infrastructure.spring;

import com.github.monaboiste.infrastructure.spring.command.Command;

public class MarkOrderAsDeliveredCommand extends Command {

    public MarkOrderAsDeliveredCommand(Long orderId) {
        super(orderId);
    }
}
