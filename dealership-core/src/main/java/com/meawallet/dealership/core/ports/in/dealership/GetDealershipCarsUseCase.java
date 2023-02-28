package com.meawallet.dealership.core.ports.in.dealership;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;

import java.util.List;

public interface GetDealershipCarsUseCase {

    List<Car> listCarsInDealership(CarDealership dealership);
}
