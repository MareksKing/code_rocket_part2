package com.meawallet.dealership.core.ports.in.user;

import com.meawallet.dealership.domain.Car;

public interface AddCarToUserBookmarksUseCase {

    void addCarToUserBookmarks(Car car);
}
