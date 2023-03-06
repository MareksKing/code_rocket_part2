package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.FindUserByIdPort;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdPort {

    private final UserRepository userRepository;
    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findUserById(id);
    }
}
