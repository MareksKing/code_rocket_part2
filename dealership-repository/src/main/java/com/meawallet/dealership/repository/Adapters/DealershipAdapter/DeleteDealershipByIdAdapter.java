package com.meawallet.dealership.repository.Adapters.DealershipAdapter;

import com.meawallet.dealership.core.ports.out.dealership.DeleteDealershipByIdPort;
import com.meawallet.dealership.repository.repository.dealershipRepository.DealershipRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class DeleteDealershipByIdAdapter implements DeleteDealershipByIdPort {

    private final DealershipRepository dealershipRepository;
    @Override
    public void delete(Integer id) {
        dealershipRepository.deleteById(id);
    }
}
