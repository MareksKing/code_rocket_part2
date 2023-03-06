package com.meawallet.dealership.core.ports.in.dealership;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;

public interface AddCarToDealershipUseCase {

    void addCarToDealership(Car car, CarDealership dealership);
}
