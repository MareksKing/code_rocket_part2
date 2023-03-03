package com.meawallet.dealership.in.dto;


public record CreateUserInRequest(String name, String surname, String email, String phoneNumber, String town) {
}
