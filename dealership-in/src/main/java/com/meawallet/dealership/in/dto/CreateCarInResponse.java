package com.meawallet.dealership.in.dto;


public record CreateCarInResponse(String model, String brand, Integer year, String engineType, Double engineVolume,
                                  Short horsePower, Integer drivenKm, String numberPlate) {

}
