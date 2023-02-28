package com.meawallet.dealership.repository.converters;

import com.meawallet.dealership.repository.entity.CarEntity;
import com.meawallet.mareks.domain.Car;
import org.springframework.stereotype.Component;

@Component
public class CarEntityToDomainConverter {

    public Car convert(CarEntity entity) {
        return Car.builder()
                .model(entity.getModel())
                .brand(entity.getBrand())
                .year(entity.getYear())
                .engineType(entity.getEngineType())
                .engineVolume(entity.getEngineVolume())
                .horsePower(entity.getHorsePower())
                .drivenKm(entity.getDrivenKm())
                .numberPlate(entity.getNumberPlate())
                .id(entity.getId())
                .build();
    }
}
