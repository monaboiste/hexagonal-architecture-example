package com.github.monaboiste.infrastructure.spring.domain.order.adapter.incoming;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

/**
 * Exposes domain's services as a spring bean.
 *
 * Some services may be overridden here in the future, e.g.
 * add @Transactional to the services' methods.
 */
@Service
class FoodOrderAppDomainQueryService implements FoodOrderQueryService {

    @Delegate
    private final FoodOrderQueryService foodOrderQueryServiceDelegate;

    public FoodOrderAppDomainQueryService(FoodOrderFacade foodOrderFacade) {
        this.foodOrderQueryServiceDelegate = foodOrderFacade.getFoodOrderQueryService();
    }
}