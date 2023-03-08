package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.SaveDealershipUseCase;
import com.meawallet.dealership.core.ports.out.dealership.SaveDealershipPort;
import com.meawallet.dealership.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SaveDealershipService implements SaveDealershipUseCase {

    private final SaveDealershipPort saveDealershipPort;
    @Override
    public CarDealership saveDealership(CarDealership dealership) {
        return saveDealershipPort.save(dealership);
    }
}
