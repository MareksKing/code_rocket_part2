package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.car.GetCarUseCase;
import com.meawallet.dealership.core.ports.in.car.SaveCarUseCase;

import com.meawallet.dealership.in.converters.CarToCreateCarInResponseConverter;
import com.meawallet.dealership.in.converters.CarToGetCarInResponseConverter;
import com.meawallet.dealership.in.converters.CreateCarInRequestToDomainConverter;
import com.meawallet.dealership.in.dto.CreateCarInRequest;
import com.meawallet.dealership.in.dto.CreateCarInResponse;

import com.meawallet.dealership.in.dto.GetCarInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class CarController {


    private final SaveCarUseCase saveCarUseCase;
    private final GetCarUseCase getCarUseCase;
    private final CreateCarInRequestToDomainConverter createCarInRequestToDomainConverter;
    private final CarToCreateCarInResponseConverter carToCreateCarInResponseConverter;
    private final CarToGetCarInResponseConverter carToGetCarInResponseConverter;


    @PostMapping(value = "/car")
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

    @GetMapping(value = "/car/{id}")
    public GetCarInResponse findCarById(@PathVariable Integer id){
        var car = getCarUseCase.getCar(id);
        return carToGetCarInResponseConverter.convert(car);

    }

}
