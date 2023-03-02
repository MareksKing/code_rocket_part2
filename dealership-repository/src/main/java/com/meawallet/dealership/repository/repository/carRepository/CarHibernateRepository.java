package com.meawallet.dealership.repository.repository.carRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.converters.CarEntityToDomainConverter;
import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.entity.CarEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@Transactional
@AllArgsConstructor
public class CarHibernateRepository implements CarRepository{

    private final SessionFactory sessionFactory;
    private final CarDomainToEntityConverter carDomainToEntityConverter;
    private final CarEntityToDomainConverter carEntityToDomainConverter;
    @Override
    public void save(Car car) {
        var entity = carDomainToEntityConverter.convert(car);
        sessionFactory.getCurrentSession().persist(entity);
    }


    @Override
    public Optional<Car> findCarById(Integer id) {

        var entity = sessionFactory.getCurrentSession().find(CarEntity.class, id);
        return Optional.ofNullable(entity)
                .map(carEntityToDomainConverter::convert);
    }
}
