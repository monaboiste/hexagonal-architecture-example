package com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.infrastructure.spring.command.CommandBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FoodOrderDomainConfig {

    @Bean
    public FoodOrderFacade foodOrderFacade(FoodOrderDatabase foodOrderDatabase,
                                           Logistics logistics) {
        return new FoodOrderFacade(foodOrderDatabase, logistics);
    }

    @Bean
    public FoodOrderDatabase foodOrderDatabase() {
        // TODO: replace with JPA repository
        return new InMemoryFoodOrderDatabase();
    }

    @Bean
    public Logistics foodOrderLogistics(CommandBus commandBus) {
        return new DefaultLogistics(commandBus);
    }
}
