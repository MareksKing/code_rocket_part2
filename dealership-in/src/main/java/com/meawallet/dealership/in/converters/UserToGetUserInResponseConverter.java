package com.meawallet.dealership.in.converters;

import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.in.dto.GetUserInResponse;

public class UserToGetUserInResponseConverter {

    public GetUserInResponse convert(User user){
        return new GetUserInResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPhoneNumber(), user.getTown());
    }
}
