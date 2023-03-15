package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VehicleFuelConsumption {
    //Норма потребления
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    private Vehicle vehicle;
    private Double consumptionrate;
    @OneToOne
    private FuelType fuelType;
}
