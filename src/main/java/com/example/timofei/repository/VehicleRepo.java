package com.example.timofei.repository;

import com.example.timofei.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<Vehicle,Long> {
}
