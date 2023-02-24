package com.meawallet.mareks.database;

import com.meawallet.mareks.domain.Car;
import com.meawallet.mareks.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findUserById(Integer id);

    List<Car> listUserCars(User user);

    void addCarToBookmarks(Car car);
}
