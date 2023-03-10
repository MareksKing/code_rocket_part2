package com.meawallet.dealership.in.dto;

public record UpdateUserInRequest (
        String name,
        String surname,
        String email,
        String phoneNumber,
        String town
){
}
