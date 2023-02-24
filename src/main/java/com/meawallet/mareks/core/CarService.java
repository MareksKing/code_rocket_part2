package com.meawallet.mareks.core;

import com.meawallet.mareks.database.CarRepository;
import com.meawallet.mareks.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void save(Car car){
        carRepository.save(car);
    }

    public Car getCarById(Integer id){
        return carRepository.findCarById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }
}
