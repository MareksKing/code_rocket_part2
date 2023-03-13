package com.meawallet.dealership.repository.Adapters.CarAdapter;

import com.meawallet.dealership.core.ports.out.car.DeleteCarByIdPort;
import com.meawallet.dealership.repository.entity.UserEntity;
import com.meawallet.dealership.repository.repository.carRepository.CarRepository;
import com.meawallet.dealership.repository.repository.userRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class DeleteCarByIdAdapter implements DeleteCarByIdPort {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public void delete(Integer id) {
        for (UserEntity user : userRepository.findAll()){
            if(user.getBookmarks().contains(carRepository.findById(id).get())){
                user.getBookmarks().remove(carRepository.findById(id).get());
                userRepository.save(user);
            }
        }
        carRepository.deleteById(id);
    }
}
