package com.github.monaboiste.infrastructure.spring.commandbus.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Command {

    private final Long orderId;
}
