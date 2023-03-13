package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.user.*;
import com.meawallet.dealership.in.converters.*;
import com.meawallet.dealership.in.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    private final CarToGetCarInResponseConverter carToGetCarInResponseConverter;

    @PostMapping(value = "/users")
    public ResponseEntity<CreateUserInResponse> create(@RequestBody CreateUserInRequest request){
        var user = createUserInRequestToDomainConverter.convert(request);
        var createdUser = saveUserUseCase.saveUser(user);
        var responseBody = userToCreateUserInResponseConverter.convert(createdUser);

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

    @PostMapping(value = "/users/{userId}/{carId}")
    public List<GetCarInResponse> addCarToUserBookmarks(@PathVariable Integer carId, @PathVariable Integer userId){
        addCarToUserBookmarksUseCase.addCarToUserBookmarks(carId, userId);
        var carList = getUserBookmarks(userId);

        return carList;

    }

    @GetMapping(value = "/users/{id}/bookmarks")
    public List<GetCarInResponse> getUserBookmarks(@PathVariable Integer id){
        return getUserBookmarksUseCase.listUserBookmarks(id).stream()
                .map(carToGetCarInResponseConverter::convert)
                .toList();
    }
}
