package com.meawallet.dealership.core.ports.out.car;

import com.meawallet.dealership.domain.Car;

import java.util.Optional;

public interface FindCarByIdPort {

    Optional<Car> findCarById(Integer id);
}
