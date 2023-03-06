package com.meawallet.dealership.repository.repository.dealershipRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.entity.CarEntity;

import java.util.List;
import java.util.Optional;

public interface DealershipRepository {

    CarDealership save(CarDealership dealership);

    Optional<CarDealership> findDealershipById(Integer id);

    List<Car> listCarsInDealership(CarDealership dealership);

    void addCarToDealership(Car car, CarDealership dealership);
}
