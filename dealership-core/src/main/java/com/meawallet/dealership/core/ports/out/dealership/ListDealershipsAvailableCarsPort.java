package com.meawallet.dealership.core.ports.out.dealership;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;

import java.util.List;

public interface ListDealershipsAvailableCarsPort {

    List<Car> listAvailableCarsInDealership(CarDealership dealership);
}
