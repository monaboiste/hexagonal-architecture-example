package com.github.monaboiste.infrastructure.spring.commandbus.command;

public class MarkOrderAsOnTheWayCommand extends Command {

    public MarkOrderAsOnTheWayCommand(Long orderId) {
        super(orderId);
    }
}
