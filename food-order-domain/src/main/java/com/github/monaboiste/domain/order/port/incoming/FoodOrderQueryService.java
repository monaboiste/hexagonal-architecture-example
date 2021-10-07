package com.github.monaboiste.domain.order.port.incoming;

import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;

public interface FoodOrderQueryService {

    FoodOrderDto findById(Long orderId);
}
