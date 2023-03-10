package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.GetAllUsersUseCase;
import com.meawallet.dealership.core.ports.out.user.FindAllUsersPort;
import com.meawallet.dealership.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllUsersService implements GetAllUsersUseCase {

    private final FindAllUsersPort findAllUsersPort;

    @Override
    public List<User> getAll() {
        return findAllUsersPort.findAll();
    }
}
