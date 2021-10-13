package com.github.monaboiste.commandbus.command;

import com.github.monaboiste.commandbus.Command;

public class PrepareDishCommand extends Command {

    public PrepareDishCommand(Long orderId) {
        super(orderId);
    }
}
