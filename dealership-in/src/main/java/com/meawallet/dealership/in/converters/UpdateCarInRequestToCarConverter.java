package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.in.dto.UpdateCarInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateCarInRequestToCarConverter {
    public Car convert(UpdateCarInRequest request, Integer id) {
        return Car.builder()
                .id(id)
                .brand(request.brand())
                .model(request.model())
                .year(request.year())
                .engineType(request.engineType())
                .engineVolume(request.engineVolume())
                .horsePower(request.horsePower())
                .drivenKm(request.drivenKm())
                .numberPlate(request.numberPlate())
                .build();
    }
}
