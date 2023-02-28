package com.meawallet.dealership.core.ports.out.dealership;

import com.meawallet.dealership.domain.Car;

public interface AddCarToDealershipPort {

    void addCarToDealershipList(Car car);
}
