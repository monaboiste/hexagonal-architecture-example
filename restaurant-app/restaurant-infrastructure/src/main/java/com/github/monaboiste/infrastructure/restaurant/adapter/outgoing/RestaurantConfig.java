package com.github.monaboiste.infrastructure.restaurant.adapter.outgoing;

import com.github.monaboiste.commandbus.CommandBus;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import com.github.monaboiste.domain.restaurant.RestaurantFacade;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RestaurantConfig {

    @Bean
    public RestaurantFacade restaurantFacade(FoodOrderDetails foodOrderDetails,
                                             FoodOrderNotifier foodOrderNotifier) {
        return new RestaurantFacade(foodOrderDetails, foodOrderNotifier);
    }

    @Bean("restaurantFoodOrderDetails")
    public FoodOrderDetails foodOrderDetails(FoodOrderQueryService foodOrderQueryService) {
        return new FoodOrderDetailsAdapter(foodOrderQueryService);
    }

    @Bean("restaurantFoodOrderNotifier")
    public FoodOrderNotifier foodOrderNotifier(CommandBus commandBus) {
        return new FoodOrderNotifierAdapter(commandBus);
    }
}
