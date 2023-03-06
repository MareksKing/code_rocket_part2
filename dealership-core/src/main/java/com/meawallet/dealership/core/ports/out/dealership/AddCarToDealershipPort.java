package com.meawallet.dealership.core.ports.out.dealership;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;

public interface AddCarToDealershipPort {

    void addCarToDealershipList(Car car, CarDealership dealership);
}
