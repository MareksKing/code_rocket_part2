package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.GetUserUseCase;
import com.meawallet.dealership.core.ports.out.user.FindUserByIdPort;
import com.meawallet.dealership.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class GetUserService implements GetUserUseCase {

    private final FindUserByIdPort findUserByIdPort;
    @Override
    public User getUser(Integer id) {
        return findUserByIdPort.findUserById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
