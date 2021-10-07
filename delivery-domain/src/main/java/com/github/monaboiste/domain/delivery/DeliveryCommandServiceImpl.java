package com.github.monaboiste.domain.delivery;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import com.github.monaboiste.domain.delivery.port.shared.FoodOrderDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class DeliveryCommandServiceImpl implements DeliveryCommandService {

    private final FoodOrderDetails foodOrderDetails;
    private final FoodOrderNotifier foodOrderNotifier;

    @Override
    public void deliver(Long foodOrderId) {
        FoodOrderDetailsDto orderDetailsDto = foodOrderDetails.get(foodOrderId);

        log.info("[DELIVERY] Delivering order: {} at {}",
                foodOrderId, orderDetailsDto.getAddress());

        foodOrderNotifier.onDelivered(foodOrderId);
    }
}
