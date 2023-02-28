package com.meawallet.dealership.repository.converters;

import com.meawallet.dealership.repository.entity.UserEntity;
import com.meawallet.mareks.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToDomainConverter {

    public User convert(UserEntity entity) {
        return User.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .town(entity.getTown())
                .id(entity.getId())
                .build();
    }
}
