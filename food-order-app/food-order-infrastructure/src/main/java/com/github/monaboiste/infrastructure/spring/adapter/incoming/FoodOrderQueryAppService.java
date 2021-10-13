package com.github.monaboiste.infrastructure.spring.adapter.incoming;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

/**
 * Exposes domain's services as a spring bean.
 * <p>
 * Some services may be overridden here in the future, e.g.
 * add @Transactional to the services' methods.
 */
@Service("foodOrderQueryService")
class FoodOrderQueryAppService implements FoodOrderQueryService {

    @Delegate
    private final FoodOrderQueryService foodOrderQueryServiceDelegate;

    public FoodOrderQueryAppService(FoodOrderFacade foodOrderFacade) {
        this.foodOrderQueryServiceDelegate = foodOrderFacade.getFoodOrderQueryService();
    }
}
