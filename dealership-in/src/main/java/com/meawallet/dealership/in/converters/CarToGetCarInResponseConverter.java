package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.in.dto.GetCarInResponse;
import org.springframework.stereotype.Component;

@Component
public class CarToGetCarInResponseConverter {

    public GetCarInResponse convert(Car car) {
        return new GetCarInResponse(car.getId(), car.getBrand(), car.getModel(), car.getYear(), car.getEngineType(), car.getEngineVolume(), car.getHorsePower(), car.getDrivenKm(), car.getNumberPlate());
    }
}
