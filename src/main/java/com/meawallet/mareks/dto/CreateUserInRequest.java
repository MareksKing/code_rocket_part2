package com.meawallet.mareks.dto;


import lombok.Value;

@Value
public record CreateUserInRequest(String name, String surname, String email, String phoneNumber, String town) {

}
