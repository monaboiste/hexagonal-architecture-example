package com.github.monaboiste.infrastructure.spring.domain.restaurant.adapter.incoming;

import com.github.monaboiste.domain.restaurant.RestaurantFacade;
import com.github.monaboiste.domain.restaurant.port.incoming.CookCommandService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

@Service
class CookCommandAppService implements CookCommandService {

    @Delegate
    private final CookCommandService cookCommandServiceDelegate;

    public CookCommandAppService(RestaurantFacade restaurantFacade) {
        this.cookCommandServiceDelegate = restaurantFacade.getCookCommandService();
    }
}
