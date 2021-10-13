package com.github.monaboiste.infrastructure.delivery.adapter.outgoing;

import com.github.monaboiste.commandbus.CommandBus;
import com.github.monaboiste.domain.delivery.DeliveryFacade;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DeliveryConfig {

    @Bean
    public DeliveryFacade deliveryFacade(FoodOrderDetails foodOrderDetails,
                                         FoodOrderNotifier foodOrderNotifier) {
        return new DeliveryFacade(foodOrderDetails, foodOrderNotifier);
    }

    @Bean("deliveryFoodOrderDetails")
    public FoodOrderDetails foodOrderDetails(FoodOrderQueryService foodOrderQueryService) {
        return new FoodOrderDetailsAdapter(foodOrderQueryService);
    }

    @Bean("deliveryFoodOrderNotifier")
    public FoodOrderNotifier foodOrderNotifier(CommandBus commandBus) {
        return new FoodOrderNotifierAdapter(commandBus);
    }
}
