package com.meawallet.dealership.core.ports.out.dealership;

import com.meawallet.dealership.domain.CarDealership;

public interface SaveDealershipPort {

    CarDealership save(CarDealership dealership);
}
