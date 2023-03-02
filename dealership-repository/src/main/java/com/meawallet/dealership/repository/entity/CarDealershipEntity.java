package com.meawallet.dealership.repository.entity;

import com.meawallet.dealership.domain.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
@Entity
@Table(name = "dealership")
@AllArgsConstructor
@NoArgsConstructor
public class CarDealershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dealershipId;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "dealership")
    private final Collection<CarEntity> availableCars = new ArrayList<>();
}
