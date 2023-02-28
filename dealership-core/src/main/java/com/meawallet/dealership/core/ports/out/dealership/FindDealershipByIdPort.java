package com.meawallet.dealership.core.ports.out.dealership;

import com.meawallet.dealership.domain.CarDealership;

import java.util.Optional;

public interface FindDealershipByIdPort {

    Optional<CarDealership> findDealershipById(Integer id);
}
