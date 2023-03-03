package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.in.dto.CreateDealershipInRequest;

public class CreateDealershipInRequestToDomainConverter {

    public CarDealership convert(CreateDealershipInRequest request){
        return CarDealership.builder()
                .name(request.name())
                .location(request.location())
                .build();
    }
}
