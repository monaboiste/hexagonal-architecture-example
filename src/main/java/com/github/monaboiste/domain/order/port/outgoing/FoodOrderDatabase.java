package com.github.monaboiste.domain.order.port.outgoing;

import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;

import java.util.Collection;

public interface FoodOrderDatabase {

    void save(FoodOrderDto foodOrderDto);
    FoodOrderDto findById(Long orderId);
    Collection<FoodOrderDto> findByState(FoodOrderState state);
}
