package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.user.AddCarToUserBookmarksUseCase;
import com.meawallet.dealership.core.ports.in.user.GetUserBookmarksUseCase;
import com.meawallet.dealership.core.ports.in.user.GetUserUseCase;
import com.meawallet.dealership.core.ports.in.user.SaveUserUseCase;
import com.meawallet.dealership.in.converters.CreateUserInRequestToDomainConverter;
import com.meawallet.dealership.in.converters.UserToCreateUserInResponseConverter;
import com.meawallet.dealership.in.converters.UserToGetUserInResponseConverter;
import com.meawallet.dealership.in.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class UserController {

    private final GetUserBookmarksUseCase getUserBookmarksUseCase;

    private final GetUserUseCase getUserUseCase;

    private final AddCarToUserBookmarksUseCase addCarToUserBookmarksUseCase;

    private final SaveUserUseCase saveUserUseCase;

    private final CreateUserInRequestToDomainConverter createUserInRequestToDomainConverter;
    private final UserToGetUserInResponseConverter userToGetUserInResponseConverter;
    private final UserToCreateUserInResponseConverter userToCreateUserInResponseConverter;

    @PostMapping(value = "/users")
    public ResponseEntity<CreateUserInResponse> create(@RequestBody CreateUserInRequest request){
        var dealership = createUserInRequestToDomainConverter.convert(request);
        var createdDealership = saveUserUseCase.saveUser(dealership);
        var responseBody = userToCreateUserInResponseConverter.convert(createdDealership);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);

    }

    @GetMapping(value = "/users/{id}")
    public GetUserInResponse findUserById(@PathVariable Integer id){
        var dealership = getUserUseCase.getUser(id);
        return userToGetUserInResponseConverter.convert(dealership);

    }
}
