package com.meawallet.mareks.database;

import com.meawallet.mareks.domain.Car;
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
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "dealership")
    private Collection<Car> availableCars = new ArrayList<>();
}
