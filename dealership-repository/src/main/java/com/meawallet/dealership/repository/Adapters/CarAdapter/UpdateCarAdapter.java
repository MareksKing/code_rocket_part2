package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.UpdateCarPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class UpdateCarAdapter implements UpdateCarPort {
    private final CarRepository carRepository;
    private final CarDomainToEntityConverter carDomainToUserEntityConverter;

    @Override
    public void update(Car car) {
        var entity = carDomainToUserEntityConverter.convert(car);
        carRepository.save(entity);
    }
}
