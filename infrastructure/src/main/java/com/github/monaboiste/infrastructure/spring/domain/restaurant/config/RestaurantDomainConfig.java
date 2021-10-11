package com.github.monaboiste.infrastructure.spring.domain.restaurant.config;

import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.domain.restaurant.RestaurantFacade;
import com.github.monaboiste.infrastructure.spring.domain.restaurant.adapter.outgoing.FoodOrderDetailsAdapter;
import com.github.monaboiste.infrastructure.spring.domain.restaurant.adapter.outgoing.FoodOrderNotifierAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantDomainConfig {

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
    public FoodOrderNotifier foodOrderNotifier(ApplicationEventPublisher eventPublisher) {
        return new FoodOrderNotifierAdapter(eventPublisher);
    }
}
