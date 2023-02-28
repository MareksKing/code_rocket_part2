package com.meawallet.dealership.core.ports.in.user;

import com.meawallet.dealership.domain.User;

public interface GetUserUseCase {

    User getUser(Integer id);
}
