package com.github.monaboiste.infrastructure.spring;

import com.github.monaboiste.domain.order.FoodOrderFacade;
import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class AppConfig {

    @Bean
    public FoodOrderFacade foodOrderFacade(FoodOrderDatabase foodOrderDatabase) {
        return new FoodOrderFacade(foodOrderDatabase);
    }

    @Bean FoodOrderDatabase foodOrderDatabase() {
        // TODO: replace with JPA repository
        return new FoodOrderDatabase() {
            private final ConcurrentHashMap<Long, FoodOrderDto> db
                    = new ConcurrentHashMap<>();

            @Override
            public void save(FoodOrderDto foodOrderDto) {
                db.put(foodOrderDto.getId(), foodOrderDto);
            }

            @Override
            public FoodOrderDto findById(Long orderId) {
                return db.get(orderId);
            }
        };
    }
}
