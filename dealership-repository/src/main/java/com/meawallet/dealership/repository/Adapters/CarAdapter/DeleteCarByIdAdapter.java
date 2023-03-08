package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.DeleteCarByIdPort;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class DeleteCarByIdAdapter implements DeleteCarByIdPort {

    private final CarRepository carRepository;
    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
