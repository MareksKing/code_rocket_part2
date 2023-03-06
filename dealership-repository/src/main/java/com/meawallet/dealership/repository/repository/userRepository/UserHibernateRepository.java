package com.meawallet.dealership.repository.repository.userRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.User;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.converters.UserDomainToEntityConverter;
import com.meawallet.dealership.repository.converters.UserEntityToDomainConverter;
import com.meawallet.dealership.repository.entity.CarEntity;
import com.meawallet.dealership.repository.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Transactional
@AllArgsConstructor
public class UserHibernateRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    private final CarDomainToEntityConverter carDomainToEntityConverter;
    private final UserDomainToEntityConverter userDomainToEntityConverter;

    private final UserEntityToDomainConverter userEntityToDomainConverter;
    @Override
    public User save(User user) {
        var entity = userDomainToEntityConverter.convert(user);
        sessionFactory.getCurrentSession().persist(entity);
        return userEntityToDomainConverter.convert(entity);
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        var entity = sessionFactory.getCurrentSession().find(UserEntity.class, id);
        return Optional.ofNullable(entity)
                .map(userEntityToDomainConverter::convert);
    }

    @Override
    public List<Car> listUserCars(User user) {
        return user.getBookmarks().stream().toList();
    }

    @Override
    public void addCarToBookmarks(Car car, User user) {
        var carEntity = carDomainToEntityConverter.convert(car);
        var userEntity = userDomainToEntityConverter.convert(user);
        userEntity.getBookmarks().add(carEntity);
    }
}
