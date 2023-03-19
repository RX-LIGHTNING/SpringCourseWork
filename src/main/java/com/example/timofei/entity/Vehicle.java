package com.example.timofei.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

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
    private byte[] document;

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(MultipartFile document) throws IOException {

        this.document = document.getBytes();
    }
}
