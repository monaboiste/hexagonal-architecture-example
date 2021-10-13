package com.github.monaboiste.commandbus.command;

import com.github.monaboiste.commandbus.Command;

public class MarkOrderAsOnTheWayCommand extends Command {

    public MarkOrderAsOnTheWayCommand(Long orderId) {
        super(orderId);
    }
}
