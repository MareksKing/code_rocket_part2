package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.in.dto.GetDealershipInResponse;
import org.springframework.stereotype.Component;

@Component
public class DealershipToGetDealershipInResponseConverter {

    public GetDealershipInResponse convert(CarDealership dealership){
        return new GetDealershipInResponse(dealership.getId(), dealership.getName(), dealership.getLocation());
    }
}
