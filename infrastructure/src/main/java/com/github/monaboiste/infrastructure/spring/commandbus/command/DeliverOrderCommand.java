package com.github.monaboiste.infrastructure.spring.commandbus.command;

import lombok.Value;

@Value
public class DeliverOrderCommand implements Command {

    Long foodOrderId;
}
