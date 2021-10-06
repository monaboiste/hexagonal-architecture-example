package com.github.monaboiste.domain.delivery;

import com.github.monaboiste.domain.delivery.port.incoming.DeliveryService;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderNotifier;
import lombok.Getter;

@Getter
public class DeliveryFacade {

    private final DeliveryService deliveryService;

    public DeliveryFacade(FoodOrderDetails foodOrderDetails,
                          FoodOrderNotifier foodOrderNotifier) {
        this.deliveryService = new DeliveryServiceImpl(foodOrderDetails, foodOrderNotifier);
    }
}
