package com.meawallet.dealership.core.ports.out.user;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;

public interface AddCarToUserBookmarksPort {

    void addCarToUserBookmarks(Car car, Integer id);
}
