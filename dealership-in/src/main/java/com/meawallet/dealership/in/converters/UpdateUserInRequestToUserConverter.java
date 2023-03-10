package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.in.dto.UpdateCarInRequest;
import com.meawallet.dealership.in.dto.UpdateUserInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserInRequestToUserConverter {
    public User convert(UpdateUserInRequest request, Integer id) {
        return User.builder()
                .id(id)
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .town(request.town())
                .build();
    }
}
