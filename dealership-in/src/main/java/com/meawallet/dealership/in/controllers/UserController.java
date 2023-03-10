package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.user.*;
import com.meawallet.dealership.in.converters.CreateUserInRequestToDomainConverter;
import com.meawallet.dealership.in.converters.UpdateUserInRequestToUserConverter;
import com.meawallet.dealership.in.converters.UserToCreateUserInResponseConverter;
import com.meawallet.dealership.in.converters.UserToGetUserInResponseConverter;
import com.meawallet.dealership.in.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController {

    private final GetUserBookmarksUseCase getUserBookmarksUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;
    private final GetUserUseCase getUserUseCase;

    private final AddCarToUserBookmarksUseCase addCarToUserBookmarksUseCase;

    private final SaveUserUseCase saveUserUseCase;

    private final CreateUserInRequestToDomainConverter createUserInRequestToDomainConverter;
    private final UserToGetUserInResponseConverter userToGetUserInResponseConverter;
    private final UserToCreateUserInResponseConverter userToCreateUserInResponseConverter;
    private final UpdateUserInRequestToUserConverter updateUserInRequestToUserConverter;

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

    @GetMapping(value = "/users")
    public List<GetUserInResponse> findAll() {
        return getAllUsersUseCase.getAll().stream()
                .map(userToGetUserInResponseConverter::convert)
                .collect(Collectors.toList());
    }


    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        deleteUserByIdUseCase.deleteUser(id);
    }


    @PutMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UpdateUserInRequest updateUserInRequest, @PathVariable Integer id) {
        var user = updateUserInRequestToUserConverter.convert(updateUserInRequest, id);
        updateUserUseCase.updateUser(user);
    }
}
