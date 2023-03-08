package com.meawallet.dealership.repository.repository.carRepository;


import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.repository.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    Optional<CarEntity> findById(Integer id);
}
