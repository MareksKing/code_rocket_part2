package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.in.dto.CreateDealershipInResponse;
import org.springframework.stereotype.Component;

@Component
public class DealershipToCreateDealershipInResponseConverter {

    public CreateDealershipInResponse convert(CarDealership dealership){
        return new CreateDealershipInResponse(dealership.getId(), dealership.getName(), dealership.getLocation());
    }
}
