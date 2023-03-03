package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.in.dto.CreateCarInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateCarInRequestToDomainConverter {

    public Car convert(CreateCarInRequest request){
        return Car.builder()
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
