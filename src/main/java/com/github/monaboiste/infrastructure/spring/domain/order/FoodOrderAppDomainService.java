package com.github.monaboiste.infrastructure.spring.domain.order;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderAppDomainService implements FoodOrderService {

    @Delegate
    private final FoodOrderService foodOrderServiceDelegate;

    public FoodOrderAppDomainService(FoodOrderFacade foodOrderFacade) {
        this.foodOrderServiceDelegate = foodOrderFacade.getFoodOrderService();
    }
}
