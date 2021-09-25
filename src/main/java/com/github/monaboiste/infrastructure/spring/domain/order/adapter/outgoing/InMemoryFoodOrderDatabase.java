package com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing;

import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryFoodOrderDatabase implements FoodOrderDatabase {
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
}
