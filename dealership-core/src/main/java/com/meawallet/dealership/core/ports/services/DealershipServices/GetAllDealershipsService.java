package com.meawallet.dealership.core.ports.services.DealershipServices;

import com.meawallet.dealership.core.ports.in.dealership.GetAllDealershipsUseCase;
import com.meawallet.dealership.core.ports.out.dealership.FindAllDealershipsPort;
import com.meawallet.dealership.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllDealershipsService implements GetAllDealershipsUseCase {

    private final FindAllDealershipsPort findAllDealershipsPort;
    @Override
    public List<CarDealership> getAll() {
        return findAllDealershipsPort.findAll();
    }
}
