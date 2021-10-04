package com.github.monaboiste.domain.order;

import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import com.github.monaboiste.domain.order.port.shared.FoodOrderState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.concurrent.atomic.AtomicLong;

/**
 * FoodOrder domain:
 * - takes the orders
 * - orchestrates the process of food preparation
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
class FoodOrder {

    private Long id;
    private String dishName;
    private String address;
    private FoodOrderState state;

    void changeState(FoodOrderState newOrderState) {
        if (state.ordinal() < newOrderState.ordinal()) {
            state = newOrderState;
        } else {
            throw new IllegalStateException(String.format(
                    "Cannot change status from [%s] to [%s]", state, newOrderState));
        }
    }

    static class FoodOrderFactory {

        @Getter
        private static final FoodOrderFactory instance = new FoodOrderFactory();
        private static final AtomicLong SEQUENCE = new AtomicLong(1L);

        private final FoodOrderMapper foodOrderMapper = Mappers.getMapper(FoodOrderMapper.class);

        FoodOrder createOrder(String dishName, String address) {
            Long orderId = SEQUENCE.getAndIncrement();
            return new FoodOrder(orderId, dishName, address, FoodOrderState.NEW);
        }

        FoodOrder from(FoodOrderDto foodOrderDto) {
            return foodOrderMapper.toFoodOrder(foodOrderDto);
        }

        FoodOrderDto from(FoodOrder foodOrder) {
            return foodOrderMapper.toFoodOrderDto(foodOrder);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface FoodOrderMapper {
            FoodOrderDto toFoodOrderDto(FoodOrder foodOrder);
            FoodOrder toFoodOrder(FoodOrderDto foodOrderDto);
        }
    }
}
