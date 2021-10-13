package com.github.monaboiste.domain.order.port.outgoing;

public interface Logistics {

    void prepareDish(Long foodOrderId);

    void deliver(Long foodOrderId);
}
