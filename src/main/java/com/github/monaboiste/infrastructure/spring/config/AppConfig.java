package com.github.monaboiste.infrastructure.spring.config;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing.InMemoryFoodOrderDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig extends InMemoryFoodOrderDatabase {

    @Bean
    public FoodOrderFacade foodOrderFacade(FoodOrderDatabase foodOrderDatabase) {
        return new FoodOrderFacade(foodOrderDatabase);
    }

    @Bean FoodOrderDatabase foodOrderDatabase() {
        // TODO: replace with JPA repository
        return new InMemoryFoodOrderDatabase();
    }
}
