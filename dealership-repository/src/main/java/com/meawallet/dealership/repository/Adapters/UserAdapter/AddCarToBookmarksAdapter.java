package com.meawallet.dealership.repository.Adapters.UserAdapter;

import com.meawallet.dealership.core.ports.out.user.AddCarToUserBookmarksPort;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.dealership.repository.entity.CarEntity;
import com.meawallet.dealership.repository.entity.UserEntity;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
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
    private final CarRepository carRepository;

    @Override
    public void addCarToUserBookmarks(Integer carId, Integer id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        CarEntity car = carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));
        user.getBookmarks().add(car);
        userRepository.save(user);
    }
}
