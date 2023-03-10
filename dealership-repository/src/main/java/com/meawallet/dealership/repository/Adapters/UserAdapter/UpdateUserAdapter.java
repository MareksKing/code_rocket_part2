package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.UpdateUserPort;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.converters.UserDomainToEntityConverter;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class UpdateUserAdapter implements UpdateUserPort {
    private final UserRepository userRepository;
    private final UserDomainToEntityConverter userDomainToEntityConverter;
    @Override
    public void update(User user) {
        var entity = userDomainToEntityConverter.convert(user);
        userRepository.save(entity);
    }
}
