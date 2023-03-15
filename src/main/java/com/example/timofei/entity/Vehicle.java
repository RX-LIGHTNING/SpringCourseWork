package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String vin;
    private String model;
    private String make;
    private String enginecapacity;
}
