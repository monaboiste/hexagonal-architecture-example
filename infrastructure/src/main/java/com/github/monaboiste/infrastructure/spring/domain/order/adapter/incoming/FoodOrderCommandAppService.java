package com.github.monaboiste.infrastructure.spring.domain.order.adapter.incoming;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderCommandService;
import lombok.experimental.Delegate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Exposes domain's services as a spring bean.
 *
 * Some services may be overridden here in the future, e.g.
 * add @Transactional to the services' methods.
 */
@Service("foodOrderCommandService")
class FoodOrderCommandAppService implements FoodOrderCommandService {

    @Delegate
    private final FoodOrderCommandService foodOrderCommandServiceDelegate;

    public FoodOrderCommandAppService(FoodOrderFacade foodOrderFacade) {
        this.foodOrderCommandServiceDelegate = foodOrderFacade.getFoodOrderCommandService();
    }
}
