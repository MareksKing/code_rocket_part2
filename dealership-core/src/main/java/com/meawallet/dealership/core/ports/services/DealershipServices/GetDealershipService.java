package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.GetDealershipUseCase;
import com.meawallet.dealership.core.ports.out.dealership.FindDealershipByIdPort;
import com.meawallet.dealership.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class GetDealershipService implements GetDealershipUseCase {

    private final FindDealershipByIdPort findDealershipByIdPort;

    @Override
    public CarDealership getDealership(Integer id) {
        return findDealershipByIdPort.findDealershipById(id).orElseThrow(() -> new IllegalArgumentException("Dealership not found"));
    }
}
