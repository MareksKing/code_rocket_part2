package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.DeleteUserByIdPort;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class DeleteUserByIdAdapter implements DeleteUserByIdPort {
    private final UserRepository userRepository;
    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
