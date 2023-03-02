package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.car.GetCarUseCase;
import com.meawallet.dealership.core.ports.in.car.SaveCarUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {

    private final GetCarUseCase getCarUseCase;

    private final SaveCarUseCase saveCarUseCase;
}
