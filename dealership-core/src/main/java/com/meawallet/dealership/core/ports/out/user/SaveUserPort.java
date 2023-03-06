package com.meawallet.dealership.core.ports.out.user;

import com.meawallet.dealership.domain.User;

public interface SaveUserPort {

    User save(User user);
}
