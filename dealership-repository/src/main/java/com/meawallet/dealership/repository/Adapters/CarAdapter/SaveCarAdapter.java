package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.SaveCarPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveCarAdapter implements SaveCarPort {

    private final CarRepository carRepository;
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
}
