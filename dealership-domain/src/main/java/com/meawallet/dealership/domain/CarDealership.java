package com.meawallet.dealership.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
public class CarDealership {

    Integer id;
    String name;
    String location;

    Collection<Car> availableCars;
}
