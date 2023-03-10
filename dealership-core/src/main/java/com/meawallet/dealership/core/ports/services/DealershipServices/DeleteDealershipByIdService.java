package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.DeleteDealershipByIdUseCase;
import com.meawallet.dealership.core.ports.out.dealership.DeleteDealershipByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteDealershipByIdService implements DeleteDealershipByIdUseCase {

    private final DeleteDealershipByIdPort deleteDealershipByIdPort;
    @Override
    public void deleteDealership(Integer id) {deleteDealershipByIdPort.delete(id);}
}
