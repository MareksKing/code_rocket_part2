package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.AddCarToUserBookmarksUseCase;
import com.meawallet.dealership.core.ports.out.user.AddCarToUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AddCarToUserBookmarksService implements AddCarToUserBookmarksUseCase {

    private final AddCarToUserBookmarksPort addCarToUserBookmarksPort;

    @Override
    public void addCarToUserBookmarks(Integer carId, Integer id) {
        addCarToUserBookmarksPort.addCarToUserBookmarks(carId, id);
    }
}
