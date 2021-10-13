package com.github.monaboiste.domain.delivery.port.shared;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodOrderDetailsDto {

    private Long foodOrderId;
    private String address;
}
