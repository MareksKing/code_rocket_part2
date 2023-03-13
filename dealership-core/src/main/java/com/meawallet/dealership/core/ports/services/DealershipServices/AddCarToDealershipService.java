package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.AddCarToDealershipUseCase;
import com.meawallet.dealership.core.ports.out.dealership.AddCarToDealershipPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AddCarToDealershipService implements AddCarToDealershipUseCase {

    private final AddCarToDealershipPort addCarToDealershipPort;

    @Override
    public void addCarToDealership(Integer carId, Integer id) {
        addCarToDealershipPort.addCarToDealershipList(carId, id);
    }
}
