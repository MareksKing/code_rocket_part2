package com.meawallet.dealership.core.ports.services.UserServices;

import com.meawallet.dealership.core.ports.in.user.GetUserBookmarksUseCase;
import com.meawallet.dealership.core.ports.out.user.ListUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
class GetUserBookmarksService implements GetUserBookmarksUseCase {

    private final ListUserBookmarksPort listUserBookmarks;
    @Override
    public List<Car> listUserBookmarks(Integer id) {
        return listUserBookmarks.listUserBookmarkedCars(id);
    }

}
