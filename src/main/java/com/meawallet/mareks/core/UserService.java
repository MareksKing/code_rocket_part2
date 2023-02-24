package com.meawallet.mareks.core;

import com.meawallet.mareks.database.UserRepository;
import com.meawallet.mareks.domain.Car;
import com.meawallet.mareks.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Integer id){
        return userRepository.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public List<Car> getUserBookmarks(User user){
        return userRepository.listUserCars(user);
    }

    public void addCarToUser(Car car){
        userRepository.addCarToBookmarks(car);
    }
}
