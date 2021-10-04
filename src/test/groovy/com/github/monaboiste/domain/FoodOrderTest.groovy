package com.github.monaboiste.domain

import com.github.monaboiste.domain.order.FoodOrderFacade
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService
import com.github.monaboiste.domain.order.port.shared.FoodOrderState
import spock.lang.Specification

class FoodOrderTest extends Specification {

    def "should create a new order"() {
        given:
            def dishName = "pizza"
            def address = "ul. Wojska Polskiego 12/4, 66-555 Warszawa"
            def foodOrderFacade = new FoodOrderFacade(new InMemoryFoodOrderDatabase())
            def foodOrderService = foodOrderFacade.getFoodOrderService()
        when:
            def orderId = foodOrderService.createOrder(dishName, address)
            def orderState = foodOrderService.getOrderState(orderId)
        then:
            assert orderId == 1L
            assert orderState == FoodOrderState.NEW
    }
}
