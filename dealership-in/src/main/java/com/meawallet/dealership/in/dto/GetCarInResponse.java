package com.meawallet.dealership.in.dto;


public record GetCarInResponse(Integer id, String model, String brand, Integer year, String engineType, Double engineVolume,
                               Short horsePower, Integer drivenKm, String numberPlate) {

}
