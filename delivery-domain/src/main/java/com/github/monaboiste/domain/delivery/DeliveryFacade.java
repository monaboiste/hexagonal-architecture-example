package com.github.monaboiste.domain.delivery;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryCommandService;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import lombok.Getter;

@Getter
public class DeliveryFacade {

    private final DeliveryCommandService deliveryCommandService;

    public DeliveryFacade(FoodOrderDetails foodOrderDetails,
                          FoodOrderNotifier foodOrderNotifier) {
        this.deliveryCommandService = new DeliveryCommandServiceImpl(foodOrderDetails, foodOrderNotifier);
    }
}
