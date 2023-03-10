package com.meawallet.dealership.core.ports.in.dealership;

import com.meawallet.dealership.domain.CarDealership;

public interface UpdateDealershipUseCase {

    void updateDealership(CarDealership dealership);
}
