package com.github.monaboiste.infrastructure.spring.domain.restaurant;

import com.github.monaboiste.infrastructure.spring.command.Command;

public class PrepareDishCommand extends Command {

    public PrepareDishCommand(Long orderId) {
        super(orderId);
    }
}
