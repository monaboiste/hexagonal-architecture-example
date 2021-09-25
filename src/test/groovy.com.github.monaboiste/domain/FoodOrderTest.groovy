package domain

import com.github.monaboiste.domain.order.FoodOrderFacade
import com.github.monaboiste.domain.order.port.incoming.FoodOrderService
import com.github.monaboiste.domain.order.port.shared.FoodOrderState
import spock.lang.Specification

class FoodOrderTest extends Specification {

    def "should create a order"() {
        given:
            FoodOrderFacade foodOrderFacade = new FoodOrderFacade(new InMemoryFoodOrderDatabase())
            FoodOrderService foodOrderService = foodOrderFacade.getFoodOrderService()
        when:
            Long orderId = foodOrderService.createOrder("burder")
            FoodOrderState orderState = foodOrderService.getOrderState(orderId)
        then:
            orderId == 1L
            orderState == FoodOrderState.NEW
    }
}
