package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.car.GetCarUseCase;
import com.meawallet.dealership.core.ports.in.car.SaveCarUseCase;
import com.meawallet.dealership.in.converters.CreateUserInRequestToDomainConverter;
import com.meawallet.dealership.in.converters.UserToCreateUserInResponseConverter;
import com.meawallet.dealership.in.converters.UserToGetUserInResponseConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {

    private final GetCarUseCase getCarUseCase;

    private final SaveCarUseCase saveCarUseCase;

    private final CreateUserInRequestToDomainConverter createUserInRequestToDomainConverter;
    private final UserToCreateUserInResponseConverter userToCreateUserInResponseConverter;
    private final UserToGetUserInResponseConverter userToGetUserInResponseConverter;
}
