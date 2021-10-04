package com.github.monaboiste.domain.restaurant;

import com.github.monaboiste.domain.restaurant.port.incoming.RestaurantService;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import lombok.Getter;

@Getter
public class RestaurantFacade {

    private final RestaurantService restaurantService;

    public RestaurantFacade(FoodOrderDetails foodOrderDetails,
                            FoodOrderNotifier foodOrderNotifier) {
        this.restaurantService = new RestaurantServiceImpl(foodOrderDetails, foodOrderNotifier);
    }
}
