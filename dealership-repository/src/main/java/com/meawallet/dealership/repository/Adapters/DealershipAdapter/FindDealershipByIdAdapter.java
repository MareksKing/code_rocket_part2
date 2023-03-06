package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.FindDealershipByIdPort;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.repository.dealershipRepository.DealershipRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class FindDealershipByIdAdapter implements FindDealershipByIdPort {
    private final DealershipRepository dealershipRepository;
    @Override
    public Optional<CarDealership> findDealershipById(Integer id) {
        return dealershipRepository.findDealershipById(id);
    }
}
