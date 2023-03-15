package com.example.timofei.service;

import com.example.timofei.entity.Driver;
import com.example.timofei.repository.DriverRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepo driverRepo;

    public Iterable<Driver> findAll(){
        return driverRepo.findAll();
    }
    public Driver findById(Long id){
        return driverRepo.findById(id).get();
    }
    public void save(Driver driver){
        driverRepo.save(driver);
    }
    public void delete(Long id){
        driverRepo.deleteById(id);
    }
}
