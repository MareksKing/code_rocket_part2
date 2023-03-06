package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.AddCarToUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class AddCarToBookmarksAdapter implements AddCarToUserBookmarksPort {

    private final UserRepository userRepository;
    @Override
    public void addCarToUserBookmarks(Car car, User user) {
        userRepository.addCarToBookmarks(car, user);
    }
}
