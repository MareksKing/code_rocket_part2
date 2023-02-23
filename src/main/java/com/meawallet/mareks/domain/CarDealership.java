package com.meawallet.mareks.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;
import java.util.Iterator;
@Value
@Builder
public class CarDealership {

    Integer id;
    String name;
    String location;

    Collection<Car> availableCars;
}
