package com.meawallet.mareks.ui.converters;

import com.meawallet.mareks.domain.Car;
import com.meawallet.mareks.domain.User;
import com.meawallet.mareks.dto.CreateUserInRequest;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


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
