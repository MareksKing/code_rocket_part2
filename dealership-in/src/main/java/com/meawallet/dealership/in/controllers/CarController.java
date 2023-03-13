package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.car.*;

import com.meawallet.dealership.in.converters.CarToCreateCarInResponseConverter;
import com.meawallet.dealership.in.converters.CarToGetCarInResponseConverter;
import com.meawallet.dealership.in.converters.CreateCarInRequestToDomainConverter;
import com.meawallet.dealership.in.converters.UpdateCarInRequestToCarConverter;
import com.meawallet.dealership.in.dto.CreateCarInRequest;
import com.meawallet.dealership.in.dto.CreateCarInResponse;

import com.meawallet.dealership.in.dto.GetCarInResponse;
import com.meawallet.dealership.in.dto.UpdateCarInRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CarController {


    private final SaveCarUseCase saveCarUseCase;
    private final GetCarUseCase getCarUseCase;
    private final GetAllCarsUseCase getAllCarsUseCase;
    private final UpdateCarUseCase updateCarUseCase;
    private final DeleteCarByIdUseCase deleteCarByIdUseCase;
    private final CreateCarInRequestToDomainConverter createCarInRequestToDomainConverter;
    private final CarToCreateCarInResponseConverter carToCreateCarInResponseConverter;
    private final CarToGetCarInResponseConverter carToGetCarInResponseConverter;

    private final UpdateCarInRequestToCarConverter updateCarInRequestToCarConverter;


    @PostMapping(value = "/cars")
    public ResponseEntity<CreateCarInResponse> create(@RequestBody CreateCarInRequest request){
        var car = createCarInRequestToDomainConverter.convert(request);
        var createdCar = saveCarUseCase.save(car);
        var responseBody = carToCreateCarInResponseConverter.convert(createdCar);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);

    }

    @GetMapping(value = "/cars/{id}")
    public GetCarInResponse findCarById(@PathVariable Integer id){
        var car = getCarUseCase.getCar(id);
        return carToGetCarInResponseConverter.convert(car);

    }

    @GetMapping(value = "/cars")
    public List<GetCarInResponse> findAll() {
        return getAllCarsUseCase.getAll().stream()
                .map(carToGetCarInResponseConverter::convert)
                .collect(Collectors.toList());
    }


    @DeleteMapping(value = "/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {

        deleteCarByIdUseCase.deleteById(id);
    }


    @PutMapping(value = "/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UpdateCarInRequest updateCarInRequest, @PathVariable Integer id) {
        var car = updateCarInRequestToCarConverter.convert(updateCarInRequest, id);
        updateCarUseCase.updateCar(car);
    }

}
