package com.meawallet.mareks.database;


import com.meawallet.mareks.domain.Car;

import java.util.Optional;

public interface CarRepository {

    void save(Car car);

    Optional<Car> findCarById(Integer id);
}
