package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.ListDealershipsAvailableCarsPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.converters.CarDealershipEntityToDomainConverter;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
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
public class ListCarsInDealershipAdapter implements ListDealershipsAvailableCarsPort {

    private final DealershipRepository dealershipRepository;
    private final CarEntityToDomainConverter carEntityToDomainConverter;
    @Override
    public List<Car> listAvailableCarsInDealership(Integer dealershipId) {

        var dealership = dealershipRepository.findById(dealershipId).orElseThrow(() -> new EntityNotFoundException("Dealership not found"));
        return dealership.getAvailableCars().stream()
                        .map(carEntityToDomainConverter::convert)
                        .toList();
    }
}
