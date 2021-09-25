package com.github.monaboiste.domain.order.port.outgoing;

import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;

public interface FoodOrderDatabase {

    void save(FoodOrderDto foodOrderDto);
    FoodOrderDto findById(Long orderId);

}
