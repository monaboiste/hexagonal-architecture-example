package com.github.monaboiste.infrastructure.spring.commandbus.command;

import lombok.Value;

@Value
public class PrepareDishCommand implements Command {

    Long foodOrderId;
}
