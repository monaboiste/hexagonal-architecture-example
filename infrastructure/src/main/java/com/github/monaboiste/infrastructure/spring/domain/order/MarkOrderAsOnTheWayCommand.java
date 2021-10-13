package com.github.monaboiste.infrastructure.spring.domain.order;

import com.github.monaboiste.infrastructure.spring.command.Command;

public class MarkOrderAsOnTheWayCommand extends Command {

    public MarkOrderAsOnTheWayCommand(Long orderId) {
        super(orderId);
    }
}
