package com.meawallet.mareks.ui.converters;

import com.meawallet.mareks.domain.CarDealership;
import com.meawallet.mareks.dto.CreateDealershipInRequest;

import java.util.Collections;

public class CreateDealershipInRequestToDomainConverter {

    public CarDealership convert(CreateDealershipInRequest request){
        return CarDealership.builder()
                .name(request.getName())
                .location(request.getLocation())
                .build();
    }
}
