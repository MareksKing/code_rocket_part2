package com.meawallet.dealership.core.ports.services.CarServices;

import com.meawallet.dealership.core.ports.in.car.GetCarUseCase;
import com.meawallet.dealership.core.ports.out.car.FindCarByIdPort;
import com.meawallet.dealership.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class GetCarService implements GetCarUseCase {

    private final FindCarByIdPort findCarByIdPort;


    @Override
    public Car getCar(Integer id) {
        return findCarByIdPort.findCarById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }
}
