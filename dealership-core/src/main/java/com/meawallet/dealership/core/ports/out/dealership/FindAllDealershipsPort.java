package com.meawallet.dealership.core.ports.out.dealership;

import com.meawallet.dealership.domain.CarDealership;

import java.util.List;

public interface FindAllDealershipsPort {

    List<CarDealership> findAll();
}
