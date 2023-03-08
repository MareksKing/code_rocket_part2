package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.FindAllCarsPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@AllArgsConstructor
public class FindAllCarsAdapter implements FindAllCarsPort {

    private final CarEntityToDomainConverter carEntityToDomainConverter;

    private final CarRepository carRepository;
    @Override
    public List<Car> findAll() {
        return carRepository.findAll().stream()
                .map(carEntityToDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
