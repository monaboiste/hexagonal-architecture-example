package com.github.monaboiste.infrastructure.spring.domain.order.adapter.outgoing;

import com.github.monaboiste.domain.order.port.outgoing.FoodOrderDatabase;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryFoodOrderDatabase implements FoodOrderDatabase {
    private final ConcurrentHashMap<Long, FoodOrderDto> db
            = new ConcurrentHashMap<>();

    @Override
    public void removeAll() {
        db.clear();
    }

    @Override
    public void save(FoodOrderDto foodOrderDto) {
        db.put(foodOrderDto.getId(), foodOrderDto);
    }

    @Override
    public FoodOrderDto findById(Long orderId) {
        return db.get(orderId);
    }

    @Override
    public Collection<FoodOrderDto> findByState(FoodOrderState state) {
        return db.values().stream()
                .filter((final var dto) -> dto.getState() == state)
                .collect(Collectors.toList());
    }
}
