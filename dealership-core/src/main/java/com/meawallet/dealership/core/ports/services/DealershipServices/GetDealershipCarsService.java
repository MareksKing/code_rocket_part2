package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.GetDealershipCarsUseCase;
import com.meawallet.dealership.core.ports.out.dealership.ListDealershipsAvailableCarsPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class GetDealershipCarsService implements GetDealershipCarsUseCase {

    private final ListDealershipsAvailableCarsPort listAvailableCars;
    @Override
    public List<Car> listCarsInDealership(CarDealership dealership) {
        return listAvailableCars.listAvailableCarsInDealership(dealership);
    }
}
