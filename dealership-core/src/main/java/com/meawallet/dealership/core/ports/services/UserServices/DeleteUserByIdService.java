package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.DeleteUserByIdUseCase;
import com.meawallet.dealership.core.ports.out.user.DeleteUserByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteUserByIdService implements DeleteUserByIdUseCase {
    private final DeleteUserByIdPort deleteUserByIdPort;
    @Override
    public void deleteUser(Integer id) {
        deleteUserByIdPort.delete(id);
    }
}
