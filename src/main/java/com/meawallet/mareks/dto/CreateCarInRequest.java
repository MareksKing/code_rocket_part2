package com.meawallet.mareks.dto;

import lombok.Value;

@Value
public class CreateCarInRequest {

    String Model;
    String Brand;
    Integer Year;

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
