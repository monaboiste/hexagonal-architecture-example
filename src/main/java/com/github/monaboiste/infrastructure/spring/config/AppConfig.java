package com.github.monaboiste.infrastructure.spring.config;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.outgoing.Logistics;
import com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing.InMemoryFoodOrderDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfig extends InMemoryFoodOrderDatabase {

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
    public Logistics foodOrderLogistics() {
        return new Logistics() {

            @Override
            public void prepareDish(Long foodOrderId) {
                log.info("Preparing order: {}", foodOrderId);
            }

            @Override
            public void deliver(Long foodOrderId) {
                log.info("Delivering order: {}", foodOrderId);
            }
        };

    }
}
