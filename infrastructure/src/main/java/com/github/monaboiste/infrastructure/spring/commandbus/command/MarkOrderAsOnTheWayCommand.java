package com.github.monaboiste.infrastructure.spring.commandbus.command;

import lombok.Value;

@Value
public class MarkOrderAsOnTheWayCommand implements Command {

    Long foodOrderId;
}
