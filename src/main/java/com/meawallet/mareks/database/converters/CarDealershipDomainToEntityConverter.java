package com.meawallet.mareks.database.converters;

import com.meawallet.mareks.database.CarDealershipEntity;
import com.meawallet.mareks.domain.CarDealership;
import org.springframework.stereotype.Component;

@Component
public class CarDealershipDomainToEntityConverter {

    public CarDealershipEntity convert(CarDealership dealership) {
        return CarDealershipEntity.builder()
                .name(dealership.getName())
                .location(dealership.getLocation())
                .build();
    }
}
