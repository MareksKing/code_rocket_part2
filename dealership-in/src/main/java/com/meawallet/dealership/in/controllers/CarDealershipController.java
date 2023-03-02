package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.dealership.AddCarToDealershipUseCase;
import com.meawallet.dealership.core.ports.in.dealership.GetDealershipCarsUseCase;
import com.meawallet.dealership.core.ports.in.dealership.GetDealershipUseCase;
import com.meawallet.dealership.core.ports.in.dealership.SaveDealershipUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarDealershipController {

    private final SaveDealershipUseCase saveDealershipUseCase;
    private final GetDealershipCarsUseCase getDealershipCarsUseCase;
    private final GetDealershipUseCase getDealershipUseCase;
    private final AddCarToDealershipUseCase addCarToDealershipUseCase;
}
