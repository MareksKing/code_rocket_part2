package com.meawallet.dealership.core.ports.services.CarServices;

import com.meawallet.dealership.core.ports.in.car.DeleteCarByIdUseCase;
import com.meawallet.dealership.core.ports.out.car.DeleteCarByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCarByIdService implements DeleteCarByIdUseCase {

    private final DeleteCarByIdPort deleteCarByIdPort;
    @Override
    public void deleteById(Integer id) {
        deleteCarByIdPort.delete(id);
    }
}
