package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.AddCarToUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.dealership.repository.entity.UserEntity;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class AddCarToBookmarksAdapter implements AddCarToUserBookmarksPort {

    private final UserRepository userRepository;
    private final CarDomainToEntityConverter carDomainToEntityConverter;
    @Override
    public void addCarToUserBookmarks(Car car, Integer id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dealership not found"));

        var entity = carDomainToEntityConverter.convert(car);
        user.getBookmarks().add(entity);
        userRepository.save(user);
    }
}
