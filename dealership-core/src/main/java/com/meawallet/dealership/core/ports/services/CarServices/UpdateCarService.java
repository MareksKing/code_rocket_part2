package com.meawallet.dealership.core.ports.services.CarServices;

import com.meawallet.dealership.core.ports.in.car.UpdateCarUseCase;
import com.meawallet.dealership.core.ports.out.car.FindCarByIdPort;
import com.meawallet.dealership.core.ports.out.car.UpdateCarPort;
import com.meawallet.dealership.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCarService implements UpdateCarUseCase {
    private final UpdateCarPort updateCarPort;
    private final FindCarByIdPort findCarByIdPort;


    @Override
    public void updateCar(Car car) {
        findCarByIdPort.findCarById(car.getId())
                .orElseThrow(() -> new IllegalArgumentException("Car not found."));

        updateCarPort.update(car);
    }
}
