package com.meawallet.dealership.core.ports.out.user;

import com.meawallet.dealership.domain.User;

public interface SaveUserPort {

    void save(User user);
}
