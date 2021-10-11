package com.github.monaboiste.infrastructure.spring.domain.delivery.adapter.outgoing;

import com.github.monaboiste.domain.delivery.port.outcoming.FoodOrderDetails;
import com.github.monaboiste.domain.delivery.port.shared.FoodOrderDetailsDto;
import com.github.monaboiste.domain.order.port.incoming.FoodOrderQueryService;
import com.github.monaboiste.domain.order.port.shared.FoodOrderDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@RequiredArgsConstructor
class FoodOrderDetailsAdapter implements FoodOrderDetails {

    private static final FoodOrderDetailsMapper MAPPER
            = Mappers.getMapper(FoodOrderDetailsMapper.class);

    private final FoodOrderQueryService foodOrderQueryService;

    @Override
    public FoodOrderDetailsDto get(Long orderId) {
        FoodOrderDto foodOrderDto = foodOrderQueryService.findById(orderId);
        return MAPPER.toFoodOrderDetailsDto(foodOrderDto);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface FoodOrderDetailsMapper {

        @Mapping(source = "id", target = "foodOrderId")
        FoodOrderDetailsDto toFoodOrderDetailsDto(FoodOrderDto foodOrderDto);

        @Mapping(source = "foodOrderId", target = "id")
        @Mapping(target = "dishName", ignore = true)
        @Mapping(target = "state", ignore = true)
        FoodOrderDto toFoodOrdersDto(FoodOrderDetailsDto foodOrderDto);
    }
}
