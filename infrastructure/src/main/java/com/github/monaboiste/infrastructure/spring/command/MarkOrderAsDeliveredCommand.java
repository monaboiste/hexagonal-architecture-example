package com.github.monaboiste.infrastructure.spring.command;

import lombok.Value;

@Value
public class MarkOrderAsDeliveredCommand {

    Long foodOrderId;
}
