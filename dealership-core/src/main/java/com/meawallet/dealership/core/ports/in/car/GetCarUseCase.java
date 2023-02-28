package com.meawallet.dealership.core.ports.in.car;

import com.meawallet.dealership.domain.Car;


public interface GetCarUseCase {

    Car getCar(Integer id);
}
