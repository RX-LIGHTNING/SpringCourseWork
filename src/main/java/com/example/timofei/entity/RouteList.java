package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RouteList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String from;
    private String destination;

    @OneToOne
    private Vehicle vehicle;

    @OneToOne
    private Driver driver;
}
