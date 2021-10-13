package com.github.monaboiste.spring;

import com.github.monaboiste.infrastructure.spring.command.Command;

public class PrepareDishCommand extends Command {

    public PrepareDishCommand(Long orderId) {
        super(orderId);
    }
}
