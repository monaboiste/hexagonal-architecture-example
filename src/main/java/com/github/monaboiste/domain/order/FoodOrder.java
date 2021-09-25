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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
class FoodOrder {

    private Long id;
    private String dishName;
    private FoodOrderState state;

    static class FoodOrderFactory {

        @Getter
        private static final FoodOrderFactory instance = new FoodOrderFactory();
        private static final AtomicLong SEQUENCE = new AtomicLong(1L);

        private final FoodOrderMapper foodOrderMapper = Mappers.getMapper(FoodOrderMapper.class);

        FoodOrder createOrder(String dishName) {
            Long orderId = SEQUENCE.getAndIncrement();
            return new FoodOrder(orderId, dishName, FoodOrderState.NEW);
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
