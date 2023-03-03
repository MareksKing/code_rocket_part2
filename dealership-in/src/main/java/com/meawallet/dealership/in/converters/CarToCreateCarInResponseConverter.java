package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.in.dto.CreateCarInResponse;

public class CarToCreateCarInResponseConverter {

    public CreateCarInResponse convert(Car car){
        return new CreateCarInResponse(car.getId(), car.getBrand(), car.getModel(), car.getYear(), car.getEngineType(), car.getEngineVolume(), car.getHorsePower(), car.getDrivenKm(), car.getNumberPlate());
    }
}
