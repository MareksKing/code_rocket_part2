package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.user.AddCarToUserBookmarksUseCase;
import com.meawallet.dealership.core.ports.in.user.GetUserBookmarksUseCase;
import com.meawallet.dealership.core.ports.in.user.GetUserUseCase;
import com.meawallet.dealership.core.ports.in.user.SaveUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final GetUserBookmarksUseCase getUserBookmarksUseCase;

    private final GetUserUseCase getUserUseCase;

    private final AddCarToUserBookmarksUseCase addCarToUserBookmarksUseCase;

    private final SaveUserUseCase saveUserUseCase;
}
