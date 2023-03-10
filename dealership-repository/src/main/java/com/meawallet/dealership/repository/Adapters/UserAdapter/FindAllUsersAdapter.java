package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.FindAllUsersPort;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.converters.CarDealershipEntityToDomainConverter;
import com.meawallet.dealership.repository.converters.UserEntityToDomainConverter;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@AllArgsConstructor
public class FindAllUsersAdapter implements FindAllUsersPort {
    private final UserRepository userRepository;
    private final UserEntityToDomainConverter userEntityToDomainConverter;
    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(userEntityToDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
