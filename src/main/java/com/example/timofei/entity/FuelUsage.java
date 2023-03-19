package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class FuelUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private FuelType fuelType;
    @OneToOne
    private Driver driver;
    @OneToOne
    private RouteList routeList;
    private Date usagedate;
    private Double usageamount;
}
