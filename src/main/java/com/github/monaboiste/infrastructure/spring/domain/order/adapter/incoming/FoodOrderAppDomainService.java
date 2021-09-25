package com.github.monaboiste.infrastructure.spring.domain.order.adapter.incoming;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

@Service
class FoodOrderAppDomainService implements FoodOrderService {

    @Delegate
    private final FoodOrderService foodOrderServiceDelegate;

    FoodOrderAppDomainService(FoodOrderFacade foodOrderFacade) {
        this.foodOrderServiceDelegate = foodOrderFacade.getFoodOrderService();
    }
}
