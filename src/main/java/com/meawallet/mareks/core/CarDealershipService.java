package com.meawallet.mareks.core;

import com.meawallet.mareks.database.DealershipRepository;
import com.meawallet.mareks.domain.Car;
import com.meawallet.mareks.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CarDealershipService {

    private final DealershipRepository dealershipRepository;

    public void save(CarDealership dealership){
        dealershipRepository.save(dealership);
    }

    public CarDealership getDealershipById(Integer id){
        return dealershipRepository.findDealershipById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dealership not found"));
    }

    public List<Car> getCarsInDealership(CarDealership dealership){
        return dealershipRepository.listCarsInDealership(dealership);
    }

    public void addCarToDealership(Car car){
        dealershipRepository.addCarToDealership(car);
    }
}
