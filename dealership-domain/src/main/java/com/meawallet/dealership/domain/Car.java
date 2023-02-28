package com.meawallet.dealership.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {

    Integer id;
    String model;
    String brand;
    Integer year;

//    enum engineType{
//        Petrol,
//        Diesel,
//        Electric,
//        Hybrid
//    }

    String engineType;
    Double engineVolume;
    Short horsePower;
    Integer drivenKm;
    String numberPlate;

}

