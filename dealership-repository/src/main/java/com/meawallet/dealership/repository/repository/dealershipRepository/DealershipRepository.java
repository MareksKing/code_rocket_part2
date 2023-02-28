package com.meawallet.dealership.repository.repository.dealershipRepository;

import com.meawallet.mareks.domain.Car;
import com.meawallet.mareks.domain.CarDealership;

import java.util.List;
import java.util.Optional;

public interface DealershipRepository {

    void save(CarDealership dealership);

    Optional<CarDealership> findDealershipById(Integer id);

    List<Car> listCarsInDealership(CarDealership dealership);

    void addCarToDealership(Car car);
}
