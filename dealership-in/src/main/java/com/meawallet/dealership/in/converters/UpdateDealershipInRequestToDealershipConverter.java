package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.in.dto.UpdateCarInRequest;
import com.meawallet.dealership.in.dto.UpdateDealershipInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateDealershipInRequestToDealershipConverter {

    public CarDealership convert(UpdateDealershipInRequest request, Integer id) {
        return CarDealership.builder()
                .id(id)
                .name(request.name())
                .location(request.location())
                .build();
    }
}
