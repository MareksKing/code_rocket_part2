package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.FindAllDealershipsPort;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.converters.CarDealershipEntityToDomainConverter;
import com.meawallet.dealership.repository.repository.dealershipRepository.DealershipRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@AllArgsConstructor
public class FindAllDealershipsAdapter implements FindAllDealershipsPort {

    private final DealershipRepository dealershipRepository;
    private final CarDealershipEntityToDomainConverter carDealershipEntityToDomainConverter;
    @Override
    public List<CarDealership> findAll() {
        return dealershipRepository.findAll().stream()
                .map(carDealershipEntityToDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
