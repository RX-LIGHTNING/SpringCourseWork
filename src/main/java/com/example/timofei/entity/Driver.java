package com.example.timofei.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String surname;
    private String patronynicname;
}
