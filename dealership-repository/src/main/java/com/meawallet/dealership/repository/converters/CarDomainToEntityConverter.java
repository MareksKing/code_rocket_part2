package com.meawallet.dealership.repository.converters;

import com.meawallet.dealership.repository.entity.CarEntity;
import com.meawallet.dealership.domain.Car;
import org.springframework.stereotype.Component;

@Component
public class CarDomainToEntityConverter {
    public CarEntity convert(Car car) {
        return CarEntity.builder()
                .carId(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .carYear(car.getYear())
                .engineType(car.getEngineType())
                .engineVolume(car.getEngineVolume())
                .horsePower(car.getHorsePower())
                .drivenKm(car.getDrivenKm())
                .numberPlate(car.getNumberPlate())
                .build();
    }
}
