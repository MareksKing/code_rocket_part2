package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.AddCarToDealershipPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.dealership.repository.entity.CarEntity;
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
    private final CarDomainToEntityConverter carDomainToEntityConverter;
    @Override
    public void addCarToDealershipList(Car car, Integer dealershipId) {
//        dealershipRepository.addCarToDealership(car, dealershipId);

        CarDealershipEntity dealership = dealershipRepository.findById(dealershipId)
                                                        .orElseThrow(() -> new EntityNotFoundException("Dealership not found"));

        var entity = carDomainToEntityConverter.convert(car);
        dealership.getAvailableCars().add(entity);
        dealershipRepository.save(dealership);


    }
}
