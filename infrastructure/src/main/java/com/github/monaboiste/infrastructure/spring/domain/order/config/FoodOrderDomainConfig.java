package com.github.monaboiste.infrastructure.spring.domain.order.config;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.domain.restaurant.port.incoming.CookCommandService;
import com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing.DefaultLogistics;
import com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing.InMemoryFoodOrderDatabase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodOrderDomainConfig {

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
    public Logistics foodOrderLogistics(ApplicationEventPublisher eventPublisher) {
        return new DefaultLogistics(eventPublisher);
    }
}
