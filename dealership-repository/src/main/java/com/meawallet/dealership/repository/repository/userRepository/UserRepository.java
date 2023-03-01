package com.meawallet.dealership.repository.repository.userRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findUserById(Integer id);

    List<Car> listUserCars(User user);

    void addCarToBookmarks(Car car);
}
