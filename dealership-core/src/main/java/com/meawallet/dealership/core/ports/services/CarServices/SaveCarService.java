package com.meawallet.dealership.core.ports.services.CarServices;

import com.meawallet.dealership.core.ports.in.car.SaveCarUseCase;
import com.meawallet.dealership.core.ports.out.car.SaveCarPort;
import com.meawallet.dealership.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SaveCarService implements SaveCarUseCase {

    private final SaveCarPort saveCarPort;

    @Override
    public Car save(Car car) {
        return saveCarPort.save(car);
    }
}
