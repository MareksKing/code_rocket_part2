package com.meawallet.dealership.repository.repository.dealershipRepository;

import com.meawallet.dealership.domain.Car;
import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.repository.entity.CarDealershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DealershipRepository extends JpaRepository<CarDealershipEntity, Integer>{

    Optional<CarDealershipEntity> findById(Integer id);

}
