package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.AddCarToDealershipPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.converters.CarDealershipEntityToDomainConverter;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.dealership.repository.entity.CarEntity;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import com.meawallet.dealership.repository.repository.dealershipRepository.DealershipRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class AddCarToDealershipAdapter implements AddCarToDealershipPort {
    private final DealershipRepository dealershipRepository;
    private final CarRepository carRepository;
    @Override
    public void addCarToDealershipList(Integer carId, Integer dealershipId) {


        CarDealershipEntity dealership = dealershipRepository.findById(dealershipId)
                                                        .orElseThrow(() -> new EntityNotFoundException("Dealership not found"));
        CarEntity car = carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        dealership.getAvailableCars().add(car);
        car.setDealership(dealership);
        dealership.getAvailableCars().stream().toList();
        dealershipRepository.save(dealership);
    }
}
