package com.meawallet.dealership.core.ports.in.car;

import com.meawallet.dealership.domain.Car;

import java.util.List;

public interface GetAllCarsUseCase {

    List<Car> getAll();
}
