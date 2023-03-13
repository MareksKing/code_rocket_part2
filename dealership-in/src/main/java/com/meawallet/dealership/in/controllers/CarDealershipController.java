package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.dealership.*;
import com.meawallet.dealership.in.converters.*;
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
public class CarDealershipController {

    private final SaveDealershipUseCase saveDealershipUseCase;
    private final GetDealershipCarsUseCase getDealershipCarsUseCase;

    private final GetAllDealershipsUseCase getAllDealershipsUseCase;
    private final DeleteDealershipByIdUseCase deleteDealershipByIdUseCase;
    private final UpdateDealershipUseCase updateDealershipUseCase;
    private final GetDealershipUseCase getDealershipUseCase;
    private final AddCarToDealershipUseCase addCarToDealershipUseCase;

    private final CreateDealershipInRequestToDomainConverter createDealershipInRequestToDomainConverter;
    private final DealershipToGetDealershipInResponseConverter dealershipToGetDealershipInResponseConverter;
    private final DealershipToCreateDealershipInResponseConverter dealershipToCreateDealershipInResponseConverter;
    private final UpdateDealershipInRequestToDealershipConverter updateDealershipInRequestToDealershipConverter;
    private final CarToGetCarInResponseConverter carToGetCarInResponseConverter;

    @PostMapping(value = "/dealership")
    public ResponseEntity<CreateDealershipInResponse> create(@RequestBody CreateDealershipInRequest request){
        var dealership = createDealershipInRequestToDomainConverter.convert(request);
        var createdDealership = saveDealershipUseCase.saveDealership(dealership);
        var responseBody = dealershipToCreateDealershipInResponseConverter.convert(createdDealership);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);

    }

    @GetMapping(value = "/dealership/{id}")
    public GetDealershipInResponse findDealershipById(@PathVariable Integer id){
        var dealership = getDealershipUseCase.getDealership(id);
        return dealershipToGetDealershipInResponseConverter.convert(dealership);

    }

    @GetMapping(value = "/dealership")
    public List<GetDealershipInResponse> findAll() {
        return getAllDealershipsUseCase.getAll().stream()
                .map(dealershipToGetDealershipInResponseConverter::convert)
                .collect(Collectors.toList());
    }


    @DeleteMapping(value = "/dealership/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        deleteDealershipByIdUseCase.deleteDealership(id);
    }


    @PutMapping(value = "/dealership/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UpdateDealershipInRequest updateDealershipInRequest, @PathVariable Integer id) {
        var car = updateDealershipInRequestToDealershipConverter.convert(updateDealershipInRequest, id);
        updateDealershipUseCase.updateDealership(car);
    }

    @PostMapping(value = "/dealership/{dealerId}/{carId}")
    public List<GetCarInResponse> addCarToDealershipList(@PathVariable Integer carId, @PathVariable Integer dealerId){
        addCarToDealershipUseCase.addCarToDealership(carId, dealerId);
        var carList = getDealershipCars(dealerId);

        return carList;

    }

    @GetMapping(value = "/dealership/{id}/availableCars")
    public List<GetCarInResponse> getDealershipCars(@PathVariable Integer id){
        return getDealershipCarsUseCase.listCarsInDealership(id).stream()
                .map(carToGetCarInResponseConverter::convert)
                .toList();
    }

}
