package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.UpdateDealershipUseCase;
import com.meawallet.dealership.core.ports.out.dealership.UpdateDealershipPort;
import com.meawallet.dealership.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateDealershipByIdService implements UpdateDealershipUseCase {

    private final UpdateDealershipPort updateDealershipPort;
    @Override
    public void updateDealership(CarDealership dealership) {
        updateDealershipPort.update(dealership);
    }
}
