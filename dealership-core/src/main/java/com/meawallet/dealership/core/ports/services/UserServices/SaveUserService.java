package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.SaveUserUseCase;
import com.meawallet.dealership.core.ports.out.user.SaveUserPort;
import com.meawallet.dealership.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;
    @Override
    public User saveUser(User user) {
       return saveUserPort.save(user);
    }
}
