package com.meawallet.dealership.core.ports.out.user;

import com.meawallet.dealership.domain.User;

import java.util.Optional;

public interface FindUserByIdPort {

    Optional<User> findUserById(Integer id);
}
