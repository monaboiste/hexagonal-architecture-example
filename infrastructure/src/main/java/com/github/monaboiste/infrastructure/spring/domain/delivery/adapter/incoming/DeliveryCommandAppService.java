package com.github.monaboiste.infrastructure.spring.domain.delivery.adapter.incoming;

import com.github.monaboiste.domain.delivery.DeliveryFacade;
import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

@Service
class DeliveryCommandAppService implements DeliveryCommandService {

    @Delegate
    private final DeliveryCommandService deliveryCommandServiceDelegate;

    public DeliveryCommandAppService(DeliveryFacade deliveryFacade) {
        this.deliveryCommandServiceDelegate = deliveryFacade.getDeliveryCommandService();
    }
}
