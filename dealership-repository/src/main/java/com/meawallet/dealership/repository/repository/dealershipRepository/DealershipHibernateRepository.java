package com.meawallet.dealership.repository.repository.dealershipRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.converters.CarDealershipDomainToEntityConverter;
import com.meawallet.dealership.repository.converters.CarDealershipEntityToDomainConverter;
import com.meawallet.dealership.repository.converters.CarDomainToEntityConverter;
import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import com.meawallet.dealership.repository.entity.CarEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Transactional
@AllArgsConstructor
public class DealershipHibernateRepository implements DealershipRepository{

    private final SessionFactory sessionFactory;

    private final CarDomainToEntityConverter carDomainToEntityConverter;
    private final CarDealershipDomainToEntityConverter carDealershipDomainToEntityConverter;
    private final CarDealershipEntityToDomainConverter carDealershipEntityToDomainConverter;

    @Override
    public void save(CarDealership dealership) {
        var entity = carDealershipDomainToEntityConverter.convert(dealership);
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public Optional<CarDealership> findDealershipById(Integer id) {
        var entity = sessionFactory.getCurrentSession().find(CarDealershipEntity.class, id);
        return Optional.ofNullable(entity)
                .map(carDealershipEntityToDomainConverter::convert);
    }

    @Override
    public List<CarEntity> listCarsInDealership(CarDealership dealership) {
        var entity = carDealershipDomainToEntityConverter.convert(dealership);
        return entity.getAvailableCars().stream().toList();
    }

    @Override
    public void addCarToDealership(Car car, CarDealership dealership) {
        var carEntity = carDomainToEntityConverter.convert(car);
        var dealershipEntity = carDealershipDomainToEntityConverter.convert(dealership);
        dealershipEntity.getAvailableCars().add(carEntity);

    }
}
