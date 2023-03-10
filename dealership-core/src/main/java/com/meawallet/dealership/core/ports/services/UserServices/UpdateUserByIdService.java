package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.UpdateUserUseCase;
import com.meawallet.dealership.core.ports.out.user.UpdateUserPort;
import com.meawallet.dealership.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateUserByIdService implements UpdateUserUseCase {
    private final UpdateUserPort updateUserPort;

    @Override
    public void updateUser(User user) {
        updateUserPort.update(user);
    }
}
