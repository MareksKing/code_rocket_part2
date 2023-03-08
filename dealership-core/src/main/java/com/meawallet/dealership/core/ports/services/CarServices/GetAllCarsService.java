package com.meawallet.dealership.core.ports.services.CarServices;

import com.meawallet.dealership.core.ports.in.car.GetAllCarsUseCase;
import com.meawallet.dealership.core.ports.out.car.FindAllCarsPort;
import com.meawallet.dealership.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class GetAllCarsService implements GetAllCarsUseCase {

    private final FindAllCarsPort findAllCarsPort;
    @Override
    public List<Car> getAll() {
        return findAllCarsPort.findAll();
    }
}
