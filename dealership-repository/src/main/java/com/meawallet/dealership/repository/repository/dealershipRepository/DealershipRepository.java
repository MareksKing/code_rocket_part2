package com.meawallet.dealership.repository.repository.dealershipRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;

import java.util.List;
import java.util.Optional;

public interface DealershipRepository {

    void save(CarDealership dealership);

    Optional<CarDealership> findDealershipById(Integer id);

    List<Car> listCarsInDealership(CarDealership dealership);

    void addCarToDealership(Car car);
}
