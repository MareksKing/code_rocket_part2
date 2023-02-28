package com.meawallet.dealership.repository.converters;

import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.mareks.domain.CarDealership;
import org.springframework.stereotype.Component;

@Component
public class CarDealershipEntityToDomainConverter {

    public CarDealership convert(CarDealershipEntity entity) {
        return CarDealership.builder()
                .name(entity.getName())
                .location(entity.getLocation())
                .id(entity.getId())
                .build();
    }
}
