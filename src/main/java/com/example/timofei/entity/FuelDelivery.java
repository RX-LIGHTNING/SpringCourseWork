package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class FuelDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date deliverydate;
    private Double price;
    @OneToOne
    private FuelType fuelType;
}
