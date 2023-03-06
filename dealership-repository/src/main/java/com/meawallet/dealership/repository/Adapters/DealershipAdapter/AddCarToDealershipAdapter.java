package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.AddCarToDealershipPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.repository.dealershipRepository.DealershipRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class AddCarToDealershipAdapter implements AddCarToDealershipPort {
    private final DealershipRepository dealershipRepository;
    @Override
    public void addCarToDealershipList(Car car, CarDealership dealership) {
        dealershipRepository.addCarToDealership(car, dealership);
    }
}
