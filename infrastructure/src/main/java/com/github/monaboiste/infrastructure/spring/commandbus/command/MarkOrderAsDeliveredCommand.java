package com.github.monaboiste.infrastructure.spring.commandbus.command;

import lombok.Value;

@Value
public class MarkOrderAsDeliveredCommand implements Command {

    Long foodOrderId;
}
