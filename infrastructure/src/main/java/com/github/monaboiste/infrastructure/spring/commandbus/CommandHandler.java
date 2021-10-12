package com.github.monaboiste.infrastructure.spring.commandbus;

import com.github.monaboiste.infrastructure.spring.commandbus.command.Command;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface CommandHandler<T extends Command> {

    void handle(T command);

    @SuppressWarnings("unchecked")
    default Class<T> getHandledClassType() {
        Class<T> actualTypeArgument;
        try {
            Type[] genericInterfaces = getClass().getGenericInterfaces();
            ParameterizedType type = (ParameterizedType) genericInterfaces[0];
            actualTypeArgument = (Class<T>) type.getActualTypeArguments()[0];
        } catch (ClassCastException | NullPointerException ex) {
            throw new UnsupportedOperationException(
                    "Couldn't cast class to command type: " + ex.getMessage());
        }
        return actualTypeArgument;
    }
}
