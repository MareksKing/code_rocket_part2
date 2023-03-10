package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.ListUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class ListUserBookmarksAdapter implements ListUserBookmarksPort {

    private final UserRepository userRepository;
    private final CarEntityToDomainConverter carEntityToDomainConverter;
    @Override
    public List<Car> listUserBookmarkedCars(Integer id) {

        var user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dealership not found"));
        return user.getBookmarks().stream()
                .map(carEntityToDomainConverter::convert)
                .toList();
    }
}
