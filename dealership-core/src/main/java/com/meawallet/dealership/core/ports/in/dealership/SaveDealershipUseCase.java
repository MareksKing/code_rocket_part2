package com.meawallet.dealership.core.ports.in.dealership;

import com.meawallet.dealership.domain.CarDealership;

public interface SaveDealershipUseCase {

    CarDealership saveDealership(CarDealership dealership);
}
