package com.github.monaboiste.domain.restaurant;

import com.github.monaboiste.domain.restaurant.port.incoming.CookCommandService;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import lombok.Getter;

@Getter
public class RestaurantFacade {

    private final CookCommandService cookCommandService;

    public RestaurantFacade(FoodOrderDetails foodOrderDetails,
                            FoodOrderNotifier foodOrderNotifier) {
        this.cookCommandService = new CookCommandServiceImpl(foodOrderDetails, foodOrderNotifier);
    }
}
