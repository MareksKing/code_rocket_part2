package com.meawallet.dealership.in.controllers;

import com.meawallet.dealership.core.ports.in.dealership.AddCarToDealershipUseCase;
import com.meawallet.dealership.core.ports.in.dealership.GetDealershipCarsUseCase;
import com.meawallet.dealership.core.ports.in.dealership.GetDealershipUseCase;
import com.meawallet.dealership.core.ports.in.dealership.SaveDealershipUseCase;
import com.meawallet.dealership.in.converters.CreateDealershipInRequestToDomainConverter;
import com.meawallet.dealership.in.converters.DealershipToCreateDealershipInResponseConverter;
import com.meawallet.dealership.in.converters.DealershipToGetDealershipInResponseConverter;
import com.meawallet.dealership.in.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class CarDealershipController {

    private final SaveDealershipUseCase saveDealershipUseCase;
    private final GetDealershipCarsUseCase getDealershipCarsUseCase;
    private final GetDealershipUseCase getDealershipUseCase;
    private final AddCarToDealershipUseCase addCarToDealershipUseCase;

    private final CreateDealershipInRequestToDomainConverter createDealershipInRequestToDomainConverter;
    private final DealershipToGetDealershipInResponseConverter dealershipToGetDealershipInResponseConverter;
    private final DealershipToCreateDealershipInResponseConverter dealershipToCreateDealershipInResponseConverter;

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
}
