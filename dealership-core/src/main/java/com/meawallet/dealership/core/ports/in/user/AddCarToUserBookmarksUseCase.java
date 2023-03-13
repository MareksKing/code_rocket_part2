package com.meawallet.dealership.core.ports.in.user;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;

public interface AddCarToUserBookmarksUseCase {

    void addCarToUserBookmarks(Integer carId, Integer id);
}
