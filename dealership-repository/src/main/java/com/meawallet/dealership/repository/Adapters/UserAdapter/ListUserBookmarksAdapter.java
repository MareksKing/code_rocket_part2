package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.ListUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class ListUserBookmarksAdapter implements ListUserBookmarksPort {

    private final UserRepository userRepository;
    @Override
    public List<Car> listUserBookmarkedCars(User user) {
        return userRepository.listUserCars(user);
    }
}
