package com.github.monaboiste.infrastructure.spring.domain.order;

import com.github.monaboiste.infrastructure.spring.command.Command;

public class MarkOrderAsDeliveredCommand extends Command {

    public MarkOrderAsDeliveredCommand(Long orderId) {
        super(orderId);
    }
}
