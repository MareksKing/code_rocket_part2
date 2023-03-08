package com.meawallet.dealership.core.ports.out.car;

import com.meawallet.dealership.domain.Car;

import java.util.List;

public interface FindAllCarsPort {

    List<Car> findAll();
}
