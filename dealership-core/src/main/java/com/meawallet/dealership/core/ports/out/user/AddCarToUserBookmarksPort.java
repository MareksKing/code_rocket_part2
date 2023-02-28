package com.meawallet.dealership.core.ports.out.user;

import com.meawallet.dealership.domain.Car;

public interface AddCarToUserBookmarksPort {

    void addCarToUserBookmarks(Car car);
}
