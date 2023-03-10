package com.meawallet.dealership.core.ports.in.user;

import com.meawallet.dealership.domain.User;

import java.util.List;

public interface GetAllUsersUseCase {

    List<User> getAll();
}
