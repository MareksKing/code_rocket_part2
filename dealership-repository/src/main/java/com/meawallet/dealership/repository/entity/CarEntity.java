package com.meawallet.dealership.repository.entity;

import com.meawallet.dealership.domain.CarDealership;
import com.meawallet.dealership.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    @Column(name = "model")
    private  String model;
    @Column(name = "brand")
    private String brand;
    @Column(name = "year")
    private Integer year;
    @Column(name = "engineType")
    private String engineType;
    @Column(name = "engineVolume")
    private Double engineVolume;
    @Column(name = "horsePower")
    private Short horsePower;
    @Column(name = "drivenKm")
    private Integer drivenKm;
    @Column(name = "numberPlate")
    private String numberPlate;

    @ManyToOne
    @JoinColumn(name = "dealership_Id")
    private CarDealership dealership;

    @ManyToMany(mappedBy = "bookmarks")
    private final List<User> users = new ArrayList<>();
}
