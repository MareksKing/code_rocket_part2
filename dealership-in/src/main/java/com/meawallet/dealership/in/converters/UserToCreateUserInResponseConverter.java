package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.in.dto.CreateUserInResponse;
import org.springframework.stereotype.Component;

@Component
public class UserToCreateUserInResponseConverter {

    public CreateUserInResponse convert(User user){
        return new CreateUserInResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPhoneNumber(), user.getTown());
    }
}
