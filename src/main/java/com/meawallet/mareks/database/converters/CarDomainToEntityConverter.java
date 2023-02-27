package com.meawallet.mareks.database.converters;

import com.meawallet.mareks.database.CarEntity;
import com.meawallet.mareks.domain.Car;
import org.springframework.stereotype.Component;

@Component
public class CarDomainToEntityConverter {
    public CarEntity convert(Car car) {
        return CarEntity.builder()
                .model(car.getModel())
                .brand(car.getBrand())
                .year(car.getYear())
                .engineType(car.getEngineType())
                .engineVolume(car.getEngineVolume())
                .horsePower(car.getHorsePower())
                .drivenKm(car.getDrivenKm())
                .numberPlate(car.getNumberPlate())
                .build();
    }
}
