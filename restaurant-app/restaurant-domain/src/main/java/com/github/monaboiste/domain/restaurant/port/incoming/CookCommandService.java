package com.github.monaboiste.domain.restaurant.port.incoming;

public interface CookCommandService {

    void prepareOrder(Long foodOrderId);
}
