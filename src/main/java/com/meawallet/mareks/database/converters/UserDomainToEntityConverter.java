package com.meawallet.mareks.database.converters;

import com.meawallet.mareks.database.UserEntity;
import com.meawallet.mareks.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDomainToEntityConverter {

    public UserEntity convert(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .town(user.getTown())
                .build();
    }
}
