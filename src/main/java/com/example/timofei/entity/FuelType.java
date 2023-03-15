package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Integer capacity;
    @OneToOne(cascade = CascadeType.ALL)
    private FuelDelivery fuelDelivery;
}
