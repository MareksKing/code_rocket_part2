package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.SaveCarPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveCarAdapter implements SaveCarPort {

    private final CarRepository carRepository;
    private final CarDomainToEntityConverter carDomainToEntityConverter;
    private final CarEntityToDomainConverter carEntityToDomainConverter;
    @Override
    public Car save(Car car) {
        var entity = carDomainToEntityConverter.convert(car);
        carRepository.save(entity);
        return carEntityToDomainConverter.convert(entity);

    }
}
