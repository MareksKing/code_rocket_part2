package com.meawallet.mareks.ui.converters;

import com.meawallet.mareks.domain.Car;
import com.meawallet.mareks.dto.CreateCarInRequest;

public class CreateCarInRequestToDomainConverter {

    public Car convert(CreateCarInRequest request){
        return Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .year(request.getYear())
                .engineType(request.getEngineType())
                .engineVolume(request.getEngineVolume())
                .horsePower(request.getHorsePower())
                .drivenKm(request.getDrivenKm())
                .numberPlate(request.getNumberPlate())
                .build();
    }
}
