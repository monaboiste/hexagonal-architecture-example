package com.github.monaboiste.domain

import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto
import com.github.monaboiste.domain.order.port.shared.FoodOrderState

import java.util.concurrent.ConcurrentHashMap
import java.util.stream.Collectors

class InMemoryFoodOrderDatabase implements FoodOrderDatabase {

    private final ConcurrentHashMap<Long, FoodOrderDto> db
            = new ConcurrentHashMap<>()

    @Override
    void save(FoodOrderDto foodOrderDto) {
        db.put(foodOrderDto.getId(), foodOrderDto)
    }

    @Override
    FoodOrderDto findById(Long orderId) {
        return db.get(orderId)
    }

    @Override
    Collection<FoodOrderDto> findByState(FoodOrderState state) {
        return db.values().stream()
                .filter(dto -> dto.getState() == state)
                .collect(Collectors.toList())
    }
}
