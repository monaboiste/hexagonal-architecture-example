package com.github.monaboiste.commandbus.command;

import com.github.monaboiste.commandbus.Command;

public class MarkOrderAsDeliveredCommand extends Command {

    public MarkOrderAsDeliveredCommand(Long orderId) {
        super(orderId);
    }
}
