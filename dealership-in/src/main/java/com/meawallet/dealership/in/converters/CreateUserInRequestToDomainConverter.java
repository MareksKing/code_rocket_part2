package com.meawallet.dealership.in.converters;


import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.in.dto.CreateUserInRequest;
import org.springframework.stereotype.Component;


@Component
public class CreateUserInRequestToDomainConverter {

    public User convert(CreateUserInRequest request){
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .town(request.getTown())
                .build();
    }
}
