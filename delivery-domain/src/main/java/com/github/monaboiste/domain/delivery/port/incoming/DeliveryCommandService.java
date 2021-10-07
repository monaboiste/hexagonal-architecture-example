package com.github.monaboiste.domain.delivery.port.incoming;

public interface DeliveryCommandService {

    void deliver(Long foodOrderId);
}
