package com.meawallet.dealership.repository.converters;

import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.dealership.domain.CarDealership;
import org.springframework.stereotype.Component;

@Component
public class CarDealershipDomainToEntityConverter {

    public CarDealershipEntity convert(CarDealership dealership) {
        return CarDealershipEntity.builder()
                .dealershipId(dealership.getId())
                .name(dealership.getName())
                .location(dealership.getLocation())
                .build();
    }
}
