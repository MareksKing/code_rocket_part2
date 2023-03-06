package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.SaveUserPort;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveUserAdapter implements SaveUserPort {

    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
