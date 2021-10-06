package com.github.monaboiste.domain.restaurant;

import com.github.monaboiste.domain.restaurant.port.incoming.RestaurantService;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.restaurant.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.domain.restaurant.port.shared.FoodOrderDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
class RestaurantServiceImpl implements RestaurantService {

    private final FoodOrderDetails foodOrderDetails;
    private final FoodOrderNotifier foodOrderNotifier;

    @Override
    public void prepareOrder(Long foodOrderId) {
        FoodOrderDetailsDto orderDetailsDto = foodOrderDetails.get(foodOrderId);

        log.info("[RESTAURANT] Preparing order: {} {}",
                foodOrderId, orderDetailsDto.getDishName());

        foodOrderNotifier.onOrderReady(foodOrderId);
    }
}
