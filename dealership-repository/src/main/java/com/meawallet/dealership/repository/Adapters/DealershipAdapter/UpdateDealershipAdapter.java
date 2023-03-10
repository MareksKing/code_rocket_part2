package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.UpdateDealershipPort;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.converters.CarDealershipDomainToEntityConverter;
import com.meawallet.dealership.repository.repository.dealershipRepository.DealershipRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class UpdateDealershipAdapter implements UpdateDealershipPort {

    private final DealershipRepository dealershipRepository;
    private final CarDealershipDomainToEntityConverter carDealershipDomainToEntityConverter;
    @Override
    public void update(CarDealership dealership) {
        var entity = carDealershipDomainToEntityConverter.convert(dealership);
        dealershipRepository.save(entity);
    }
}
