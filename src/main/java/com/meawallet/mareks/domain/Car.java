package com.meawallet.mareks.domain;

public class Car {

    String Model;
    String Brand;
    Integer Year;

    enum engineType{
        Petrol,
        Diesel,
        Electric,
        Hybrid
    }

    Double engineVolume;
    Short horsePower;
    Integer drivenKm;
    String numberPlate;

}

