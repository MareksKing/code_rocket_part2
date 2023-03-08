package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.FindCarByIdPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
import com.meawallet.dealership.repository.entity.CarEntity;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class FindCarByIdAdapter implements FindCarByIdPort {
    private final CarRepository carRepository;
    private final CarEntityToDomainConverter carEntityToDomainConverter;
    @Override
    public Optional<Car> findCarById(Integer id) {
        return carRepository.findById(id)
                .map(carEntityToDomainConverter::convert);
    }
}
