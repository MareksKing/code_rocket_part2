package com.meawallet.dealership.core.ports.out.user;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;

import java.util.List;

public interface ListUserBookmarksPort {

    List<Car> listUserBookmarkedCars(Integer id);
}
